create table tours (
    id bigserial primary key,
    tourName varchar(50) not null,
    tourType varchar(30) not null,
    tourPrice double precision(2) not null,
    isHot bytea not null
);

create table customers(
    id bigserial primary key,
    firstName varchar(50) not null,
    lastName varchar(30) not null,
    age integer not null,
    isRegular bytea not null
);

create table bookings (
    id bigserial primary key,
    tourId bigserial references tours(id),
    customerId bigserial references customers(id),
    bookingDate date not null ,
    totalPrice double precision(2) not null
);
