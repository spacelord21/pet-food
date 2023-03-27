create sequence comment_seq start with 1 increment by 1;
create sequence feedback_seq start with 1 increment by 1;
create sequence images_seq start with 1 increment by 1;
create sequence products_seq start with 1 increment by 1;
create table comment
(
    id          bigint  not null,
    comment     varchar(2000),
    is_admin    boolean not null,
    create_time   varchar(255),
    name        varchar(255),
    user_id     varchar(255),
    feedback_id bigint,
    avatar_id        integer not null,
    primary key (id)
);
create table feedback
(
    id            bigint  not null,
    comment       varchar(3000),
    create_time   varchar(255),
    dignities     varchar(3000),
    disadvantages varchar(3000),
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
    id          bigint  not null,
    description TEXT,
    image_url   varchar(255),
    price       numeric(38, 2),
    rating      integer not null,
    shelf_life  varchar(255),
    title       varchar(255),
    primary key (id)
);
alter table if exists comment
    add constraint FKhey9uaqtyhy9pbt6cdfe9nkhx foreign key (feedback_id) references feedback;
alter table if exists images
    add constraint FKt4m0ydhtcjpfedy3601t6pnos foreign key (feedback_id) references feedback;