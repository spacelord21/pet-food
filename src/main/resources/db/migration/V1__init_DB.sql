create sequence feedback_seq start with 1 increment by 1;
create sequence images_seq start with 1 increment by 1;
create sequence products_seq start with 1 increment by 1;
create table feedback
(
    id            bigint  not null,
    comment       varchar(255),
    create_time   varchar(255),
    dignities     varchar(255),
    disadvantages varchar(255),
    name          varchar(255),
    product_id    bigint,
    rating        integer not null,
    user_id       varchar(255),
    primary key (id)
);
create table images
(
    id          bigint not null,
    url         varchar(255),
    feedback_id bigint,
    primary key (id)
);
create table products
(
    id          bigint not null,
    description TEXT,
    image_url   varchar(255),
    price       numeric(38, 2),
    rating      float4 not null,
    shelf_life  varchar(255),
    title       varchar(255),
    primary key (id)
);
alter table if exists images
    add constraint FKt4m0ydhtcjpfedy3601t6pnos foreign key (feedback_id) references feedback;
