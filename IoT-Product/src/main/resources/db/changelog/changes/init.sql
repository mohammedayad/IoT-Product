CREATE USER postgres;
CREATE DATABASE iot-tracking-devices
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
GRANT ALL PRIVILEGES ON DATABASE tracking-devices TO postgres;