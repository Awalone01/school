create table human (
    id serial primary key,
    name text not null,
    age integer check (age > 0),
    car_id text references cars (id),
    driving_license boolean default "false"
)

create table cars (
    id serial primary key,
    company text not null,
    model text not null,
    price numeric (9, 2)
)
