create table if not exists news_type
(
    id    serial
        constraint news_type_pk
            primary key,
    name  varchar(64) not null,
    color varchar(32) not null
);

create table if not exists news
(
    id                serial
        constraint news_pk
            primary key,
    name              varchar(256)  not null,
    short_description varchar(2048) not null,
    long_description  varchar(8192) not null,
    type_id           integer       not null
        constraint news_news_type_id_fk
            references news_type
            on update cascade on delete cascade
);
