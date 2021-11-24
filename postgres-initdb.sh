#!/bin/sh -e

psql --variable=ON_ERROR_STOP=1 --username "postgres" <<-EOSQL
    CREATE ROLE docker WITH LOGIN PASSWORD 'docker';
    CREATE DATABASE "airportdb" OWNER = docker;
    GRANT ALL PRIVILEGES ON DATABASE "airportdb" TO docker;
    CREATE TABLE public.airport (
                                    id bigint NOT NULL,
                                    aptcode character varying(255),
                                    aptname text,
                                    cityname text,
                                    country text
    );
    CREATE SEQUENCE public.apt_id_seq
        START WITH 1
        INCREMENT BY 1
        NO MINVALUE
        NO MAXVALUE
        CACHE 1;
    INSERT INTO public.airport VALUES (1, 'DXB', 'Dubai International Airport', 'Dubai', 'UAE');
    INSERT INTO public.airport VALUES (2, 'JFK', 'John F Kennedy International Airport', 'Newyork', 'USA');
    INSERT INTO public.airport VALUES (3, 'COK', 'Cochin International Airport', 'Kochi', 'India');
    SELECT pg_catalog.setval('apt_id_seq', 3, true);
EOSQL