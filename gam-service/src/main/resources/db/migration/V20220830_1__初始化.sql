create table if not exists t_route_definition
(
    id         varchar(16)  not null
        primary key,
    uri        varchar(128) not null,
    predicates varchar(500) null,
    filters    varchar(500) null,
    metadata   varchar(500) null,
    `order`    int          not null
)
    comment '路由定义表' engine = InnoDB
                         charset = utf8mb4;

