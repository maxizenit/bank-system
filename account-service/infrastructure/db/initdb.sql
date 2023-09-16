--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2023-09-16 20:53:16

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

DROP DATABASE IF EXISTS "account-service-db";
--
-- TOC entry 4875 (class 1262 OID 16421)
-- Name: account-service-db; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "account-service-db" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc;


ALTER DATABASE "account-service-db" OWNER TO postgres;

\connect -reuse-previous=on "dbname='account-service-db'"

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 16430)
-- Name: account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account (
                                id integer NOT NULL,
                                user_id integer NOT NULL,
                                number text NOT NULL,
                                is_active boolean DEFAULT true NOT NULL,
                                balance money DEFAULT 0 NOT NULL
);


ALTER TABLE public.account OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16429)
-- Name: account_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.account_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.account_id_seq OWNER TO postgres;

--
-- TOC entry 4876 (class 0 OID 0)
-- Dependencies: 216
-- Name: account_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.account_id_seq OWNED BY public.account.id;


--
-- TOC entry 221 (class 1259 OID 16463)
-- Name: card; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.card (
                             id integer NOT NULL,
                             number text NOT NULL,
                             account_id integer NOT NULL,
                             expire_date date NOT NULL,
                             is_active boolean DEFAULT true NOT NULL
);


ALTER TABLE public.card OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16462)
-- Name: card_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.card_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.card_id_seq OWNER TO postgres;

--
-- TOC entry 4877 (class 0 OID 0)
-- Dependencies: 220
-- Name: card_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.card_id_seq OWNED BY public.card.id;


--
-- TOC entry 219 (class 1259 OID 16446)
-- Name: transfer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transfer (
                                 id integer NOT NULL,
                                 "timestamp" timestamp without time zone NOT NULL,
                                 sender_id integer NOT NULL,
                                 receiver_id integer NOT NULL,
                                 amount money NOT NULL
);


ALTER TABLE public.transfer OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16445)
-- Name: transfer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.transfer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.transfer_id_seq OWNER TO postgres;

--
-- TOC entry 4878 (class 0 OID 0)
-- Dependencies: 218
-- Name: transfer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.transfer_id_seq OWNED BY public.transfer.id;


--
-- TOC entry 215 (class 1259 OID 16422)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
                               id integer NOT NULL,
                               email text NOT NULL,
                               last_name text NOT NULL,
                               first_name text NOT NULL,
                               middle_name text NOT NULL
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 4702 (class 2604 OID 16433)
-- Name: account id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account ALTER COLUMN id SET DEFAULT nextval('public.account_id_seq'::regclass);


--
-- TOC entry 4706 (class 2604 OID 16466)
-- Name: card id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.card ALTER COLUMN id SET DEFAULT nextval('public.card_id_seq'::regclass);


--
-- TOC entry 4705 (class 2604 OID 16449)
-- Name: transfer id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transfer ALTER COLUMN id SET DEFAULT nextval('public.transfer_id_seq'::regclass);


--
-- TOC entry 4865 (class 0 OID 16430)
-- Dependencies: 217
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.account (id, user_id, number, is_active, balance) FROM stdin;
\.


--
-- TOC entry 4869 (class 0 OID 16463)
-- Dependencies: 221
-- Data for Name: card; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.card (id, number, account_id, expire_date, is_active) FROM stdin;
\.


--
-- TOC entry 4867 (class 0 OID 16446)
-- Dependencies: 219
-- Data for Name: transfer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transfer (id, "timestamp", sender_id, receiver_id, amount) FROM stdin;
\.


--
-- TOC entry 4863 (class 0 OID 16422)
-- Dependencies: 215
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."user" (id, email, last_name, first_name, middle_name) FROM stdin;
\.


--
-- TOC entry 4879 (class 0 OID 0)
-- Dependencies: 216
-- Name: account_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.account_id_seq', 1, false);


--
-- TOC entry 4880 (class 0 OID 0)
-- Dependencies: 220
-- Name: card_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.card_id_seq', 1, false);


--
-- TOC entry 4881 (class 0 OID 0)
-- Dependencies: 218
-- Name: transfer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.transfer_id_seq', 1, false);


--
-- TOC entry 4711 (class 2606 OID 16439)
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);


--
-- TOC entry 4715 (class 2606 OID 16471)
-- Name: card card_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.card
    ADD CONSTRAINT card_pkey PRIMARY KEY (id);


--
-- TOC entry 4713 (class 2606 OID 16451)
-- Name: transfer transfer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transfer
    ADD CONSTRAINT transfer_pkey PRIMARY KEY (id);


--
-- TOC entry 4709 (class 2606 OID 16428)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 4716 (class 2606 OID 16440)
-- Name: account account_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_user_id_fkey FOREIGN KEY (user_id) REFERENCES public."user"(id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


--
-- TOC entry 4719 (class 2606 OID 16472)
-- Name: card card_account_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.card
    ADD CONSTRAINT card_account_id_fkey FOREIGN KEY (account_id) REFERENCES public.account(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 4717 (class 2606 OID 16457)
-- Name: transfer transfer_receiver_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transfer
    ADD CONSTRAINT transfer_receiver_id_fkey FOREIGN KEY (receiver_id) REFERENCES public.account(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 4718 (class 2606 OID 16452)
-- Name: transfer transfer_sender_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transfer
    ADD CONSTRAINT transfer_sender_id_fkey FOREIGN KEY (sender_id) REFERENCES public.account(id) ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2023-09-16 20:53:16

--
-- PostgreSQL database dump complete
--

