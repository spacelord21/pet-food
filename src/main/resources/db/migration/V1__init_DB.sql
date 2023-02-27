create sequence feedback_seq start with 1 increment by 1;
create sequence images_seq start with 1 increment by 1;
create sequence products_seq start with 1 increment by 1;
create table feedbacks
(
    id            bigint  not null,
    comment       varchar(255),
    dignities     varchar(255),
    disadvantages varchar(255),
    name          varchar(255),
    product_id    bigint,
    rating        integer not null,
    primary key (id)
);
create table images
(
    id  bigint not null,
    url varchar(255),
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
create table products_images
(
    product_id bigint not null,
    image_id   bigint not null
);
alter table if exists products_images
    add constraint UK_b57fyb1vaw15kaehm04iqtpq unique (image_id);
alter table if exists products_images
    add constraint FK7sjmma186w08c4llvkc7p141d foreign key (image_id) references images;
alter table if exists products_images
    add constraint FKklsuvut5nph2btr3k9pxgc2tj foreign key (product_id) references feedbacks;
