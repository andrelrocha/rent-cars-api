create table drivers (
        id bigint auto_increment,
        name VARCHAR(255) NOT NULL,
        birthday DATE,
        cpf VARCHAR(14) NOT NULL,
        user_id BIGINT,
        PRIMARY KEY (id),

        constraint fk_driver_user_id foreign key(user_id) references users(id)
)