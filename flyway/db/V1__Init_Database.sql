create table requester
(
    id       varchar(36) not null
        primary key,
    birthday date,
    email    varchar(255),
    name     varchar(255)
);

create table campaign
(
    id              varchar(36) not null
        primary key,
    campaing_goal   double precision,
    current_ammount double precision,
    description     varchar(255),
    requester_id    varchar(36)
        constraint fknyd20u0mp6dn0t1dd444in5tc
            references requester
);


create table donation
(
    id               varchar(36) not null
        primary key,
    ammount          double precision,
    date_of_donation date,
    is_annonymous    boolean,
    message          varchar(255),
    campaign_id      varchar(36)
        constraint fksxnno1gc78toq75tqbxv95igb
            references campaign
);




