
    create sequence t_robot_SEQ start with 1 increment by 50;

    create table t_robot (
        id bigint not null,
        serialNr uuid,
        robot_name varchar(200),
        city varchar(255),
        image varchar(255),
        job varchar(255),
        primary key (id)
    );
