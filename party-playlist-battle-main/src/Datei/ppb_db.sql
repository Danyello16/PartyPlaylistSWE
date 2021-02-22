--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4
-- Dumped by pg_dump version 12.4

-- Started on 2021-02-20 00:52:32

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2840 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 204 (class 1259 OID 571883)
-- Name: content_attributes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.content_attributes (
    id integer NOT NULL,
    filetype character varying,
    filesize character varying,
    title character varying,
    artist character varying,
    album character varying,
    rating character varying,
    length integer,
    path character varying
);


ALTER TABLE public.content_attributes OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 571889)
-- Name: multi_media_content; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.multi_media_content (
    id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.multi_media_content OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 571877)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    id integer NOT NULL,
    username character varying,
    password character varying
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 571875)
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."user" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2833 (class 0 OID 571883)
-- Dependencies: 204
-- Data for Name: content_attributes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.content_attributes (id, filetype, filesize, title, artist, album, rating, length, path) FROM stdin;
\.


--
-- TOC entry 2834 (class 0 OID 571889)
-- Dependencies: 205
-- Data for Name: multi_media_content; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.multi_media_content (id, name) FROM stdin;
\.


--
-- TOC entry 2832 (class 0 OID 571877)
-- Dependencies: 203
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."user" (id, username, password) FROM stdin;
\.


--
-- TOC entry 2841 (class 0 OID 0)
-- Dependencies: 202
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_id_seq', 1, false);


--
-- TOC entry 2701 (class 2606 OID 571905)
-- Name: content_attributes content_attributes_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.content_attributes
    ADD CONSTRAINT content_attributes_pk PRIMARY KEY (id);


--
-- TOC entry 2703 (class 2606 OID 571898)
-- Name: multi_media_content multi_media_content_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.multi_media_content
    ADD CONSTRAINT multi_media_content_pk PRIMARY KEY (id);


--
-- TOC entry 2699 (class 2606 OID 571896)
-- Name: user user_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pk PRIMARY KEY (id);


--
-- TOC entry 2704 (class 2606 OID 571899)
-- Name: content_attributes content_attributes_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.content_attributes
    ADD CONSTRAINT content_attributes_fk FOREIGN KEY (id) REFERENCES public.multi_media_content(id);


-- Completed on 2021-02-20 00:52:33

--
-- PostgreSQL database dump complete
--

