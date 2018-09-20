drop table if exists pos_orders;

create table pos_orders
(
  id                             bigint  not null primary key,
  amount                         numeric(19, 2),
  guests	integer,
  closed         timestamp
);

drop table if exists address;

create table address
(
  id             bigint   not null  primary key,
  city           varchar(255),
  latitude       double precision,
  longitude      double precision,
  name           varchar(255),
  state          varchar(255),
  zip            varchar(255),
  notes          varchar(1000)
);
