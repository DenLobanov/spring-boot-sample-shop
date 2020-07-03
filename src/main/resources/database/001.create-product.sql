create table product (
    id serial primary key,
    name text not null,
    description text,
    price int not null,
    created_at timestamp not null default current_timestamp
)