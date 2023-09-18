CREATE TABLE cars (
    id BIGINT NOT NULL AUTO_INCREMENT,
    manufacturer VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    year VARCHAR(4) NOT NULL,
    color VARCHAR(255) NOT NULL,
    price VARCHAR(255) NOT NULL,
    available BOOLEAN,
    active BOOLEAN,

    PRIMARY KEY (id)
);