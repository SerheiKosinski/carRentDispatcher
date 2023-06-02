create table public.park
(
    id          bigserial
        primary key
        unique,
    park_number bigint       not null,
    created     timestamp(6) not null,
    changed     timestamp    not null,
    city        varchar(100) not null
);

alter table public.park
    owner to dev;

create index park_city_index
    on public.park (city);

create index park_park_number_index
    on public.park (park_number);

create table public.tariff
(
    id          bigserial
        primary key
        unique,
    tariff_name varchar(100) not null,
    rent_price  bigint       not null,
    created     timestamp(6) not null,
    changed     timestamp(6) not null
);

alter table public.tariff
    owner to dev;

create index tariff_rent_price_index
    on public.tariff (rent_price desc);

create index tariff_tariff_name_index
    on public.tariff (tariff_name);

create table public.users
(
    id              bigint
            primary key
        unique,
    name            varchar(200)                                        not null,
    surname         varchar(200)                                        not null,
    passport_number bigint                                              not null,
    created         timestamp(6)                                        not null,
    changed         timestamp(6)                                        not null,
    driving_license bigint                                              not null,
    passport_serial varchar(20)                                         not null,
    birthday        timestamp(6)                                        not null,
    full_name       varchar(200),
    rating          integer,
    email           varchar,
    user_password   varchar                                             not null,
    violations      varchar default 'NOT_SELECTED'::character varying   not null
);

alter table public.users
    owner to dev;

create index "clients_name _index"
    on public.users (name);

create index "clients_name _surname_index"
    on public.users (name, surname);

create index clients_surname_index
    on public.users (surname);

create unique index users_id_uindex
    on public.users (id);


create table public.technical_inspection
(
    id           bigserial
        primary key
        unique,
    mileage      bigint                not null,
    maintenance  timestamp(6),
    fuel_level   bigint                not null,
    under_repair boolean default false not null,
    "create"     timestamp(6)          not null,
    changed      timestamp(6)          not null
);

alter table public.technical_inspection
    owner to dev;

create table public.car
(
    id                      bigserial
        primary key
        unique,
    brand                   varchar(100) not null,
    mileage                 bigint       not null,
    car_body                varchar(100) not null,
    model                   varchar      not null,
    changed                 timestamp(6) not null,
    created                 timestamp(6) not null,
    technical_inspection_id bigint       not null
        unique
        constraint car_technical_inspection_id_fk
            references public.technical_inspection
            on update cascade on delete cascade
);

alter table public.car
    owner to dev;

create table public.rented_out
(
    id        bigserial
        primary key
        unique,
    rent      timestamp(6) not null,
    return    timestamp(6) not null,
    car_id    bigint       not null
        constraint rented_out_car_id_fk
            references public.car,
    users_id  bigint       not null
        constraint rented_out_users_id_fk
            references public.users,
    tariff_id bigint       not null
        constraint rented_out_tariff_id_fk
            references public.tariff,
    created   timestamp(6) not null,
    changed   timestamp(6) not null
);

alter table public.rented_out
    owner to dev;

create index rented_out_rent_index
    on public.rented_out (rent);

create index rented_out_return_index
    on public.rented_out (return);

create index car_brand_index
    on public.car (brand);

create index car_model_brand_index
    on public.car (model, brand);

create index car_model_index
    on public.car (model);

create index technical_inspection_fuel_level_index
    on public.technical_inspection (fuel_level);

create index technical_inspection_repair_index
    on public.technical_inspection (under_repair);

create table public.employees
(
    id        bigserial
        primary key
        unique,
    name    varchar(200) not null,
    surname   varchar(200) not null,
    job_title varchar(200) not null,
    created   timestamp(6) not null,
    changed   timestamp(6) not null
);

alter table public.employees
    owner to dev;

create index employees_name_surname_index
    on public.employees (name, surname);

create table public.l_car_park
(
    id      bigserial
        primary key
        unique,
    car_id  bigint       not null
        constraint l_car_park_car_id_fk
            references public.car
            on update cascade on delete cascade,
    park_id bigint       not null
        constraint l_car_park_park_id_fk
            references public.park
            on update cascade on delete cascade,
    created timestamp(6) not null,
    changed timestamp(6) not null
);

alter table public.l_car_park
    owner to dev;

create table public.l_employees_technical_inspection
(
    id                      bigserial
        primary key
        unique,
    technical_inspection_id bigint       not null,
    created                 timestamp(6) not null,
    changed                 timestamp(6) not null,
    employees_id            bigint       not null
        constraint l_employees_technical_inspection_employees_id_fk
            references public.employees
            on update cascade on delete cascade
);

alter table public.l_employees_technical_inspection
    owner to dev;

create table public.roles
(
    id        bigserial
        primary key,
    role_name varchar(100) not null,
    user_id   bigint       not null
        constraint roles_users_id_fk
            references public.users
            on update cascade on delete cascade,
    created   timestamp(6) not null,
    changed   timestamp(6) not null
);

alter table public.roles
    owner to dev;

create unique index roles_role_name_user_id_uindex
    on public.roles (role_name, user_id);

