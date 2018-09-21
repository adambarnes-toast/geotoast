var map;
var markersArray = new Array();
var FIXED_NUM_VISIBLE_MARKERS = 10;
var FIXED_MARKER_SIZE = true;

function initMap() {
  map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: 41.2571, lng: -95.9951},
    zoom: 5
  });

  // Also init the menu:
  $("#showSidebarCheckbox").click(function() {
    if(document.getElementById('showSidebarCheckbox').checked) {
      showSidebar();
    } else {
      hideSidebar();
    }
  });
  let rangeInput = document.getElementById("rangeInput");
  rangeInput.oninput = handleRangeInput;

  (function loop() {
    let rand = Math.round(Math.random() * (2500 - 500)) + 500;
    setTimeout(function() {
      orderFetcher();
      loop();  
    }, rand);
  }());
}

function handleRangeInput() {
  let rangeInput = document.getElementById("rangeInput");
  FIXED_NUM_VISIBLE_MARKERS = rangeInput.value;

  document.getElementById("sliderValue").innerHTML = rangeInput.value;
}

function orderFetcher() {
  $.getJSON("http://localhost:8080/orders/latest", function(latestOrder) {
    displayOrder(latestOrder);
  });
}

function displayOrder(order) {
  /*
   * Given an order in JSON format, drop an appropriate marker at the
   * position of the order and add it to the sidebar.
   */
  dropMarker(order);
  addToList(order);
}

function dropMarker(jsonPacket) {
  /*
   * Drops a marker on the map.
   */

  let icon = {
    scaledSize: new google.maps.Size(3*15.5, 3*30.2),
  }

  switch(jsonPacket.size) {
    case 'S':
      icon.url = "toast-pin-bronze.png";
      break;
    case 'M':
      icon.url = "toast-pin-silver.png";
      break;
    case 'L':
      icon.url = "toast-pin-gold.png";
      break;
  }

  if(!FIXED_MARKER_SIZE) {
    icon.scaledSize = new google.maps.Size(6*.155*jsonPacket.amount, 6*.302*jsonPacket.amount);
  }

  let marker = new google.maps.Marker({
    position: {
      lat: jsonPacket.address.latitude,
      lng: jsonPacket.address.longitude
    },
    animation: google.maps.Animation.DROP,
    map: map,
    icon: icon,
  });

  // Create the infowindow:
  let infowindow = new google.maps.InfoWindow({
    content: jsonPacket.address.name,
    maxWidth: 200
  });

  // Pop up the info window on mouseover and remove it on mouse exit.
  marker.addListener('mouseover', function() {
    infowindow.open(map, marker);
  });

  marker.addListener('mouseout', function() {
    infowindow.close();
  });

  // Finally add it to the markers queue and remove the oldes one if
  // necessary.
  markersArray.push(marker);

  while(markersArray.length > FIXED_NUM_VISIBLE_MARKERS) {
    let markerToRemove = markersArray.shift();
    markerToRemove.setMap(null);
  }
}

function addToList(order) {
  /*
   * Adds an order to the sidebar list of orders coming in.
   */
  let sidebar = document.getElementById("sidebar");
  let orderElementNode = document.createElement("li");

  orderElementNode.className = "orderElement";

  orderElementNode.innerHTML += "An order for $" + order.amount;
  orderElementNode.innerHTML += " came from " + order.guests;
  orderElementNode.innerHTML += " guests at " + order.address.name;

  sidebar.insertBefore(orderElementNode, sidebar.firstChild);

  setTimeout(function() {
    orderElementNode.className += " show";
  }, 100);
}

function hideSidebar() {
  $("#sidebar").hide();
  $("#map").width("100%");
}

function showSidebar() {
  $("#sidebar").show();
  $("#map").width("80%");
}
