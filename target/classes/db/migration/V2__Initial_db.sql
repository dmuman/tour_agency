create table tour (
    id bigserial primary key,
    tour_name varchar(50) not null,
    tour_type varchar(30) not null,
    tour_price double precision not null,
    is_hot boolean not null
);

create table customer(
    id bigserial primary key,
    first_name varchar(50) not null,
    last_name varchar(30) not null,
    age integer not null,
    is_regular boolean not null
);

create table booking (
    id bigserial primary key,
    tour_id bigserial references tour(id),
    customer_id bigserial references customer(id),
    booking_date date not null ,
    total_price double precision not null
);
