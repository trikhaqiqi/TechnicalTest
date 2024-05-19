--
-- PostgreSQL database dump
--

-- Dumped from database version 14.11 (Ubuntu 14.11-0ubuntu0.22.04.1)
-- Dumped by pg_dump version 14.11 (Ubuntu 14.11-0ubuntu0.22.04.1)

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
-- Name: m_nasabah; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.m_nasabah (
    kode character varying(16) NOT NULL,
    nama character varying(25)
);


ALTER TABLE public.m_nasabah OWNER TO postgres;

--
-- Name: m_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.m_user (
    user_id integer NOT NULL,
    user_name character varying(30),
    user_address character varying(50)
);


ALTER TABLE public.m_user OWNER TO postgres;

--
-- Name: m_user_office; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.m_user_office (
    nid integer,
    office_id integer
);


ALTER TABLE public.m_user_office OWNER TO postgres;

--
-- Name: m_user_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.m_user_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.m_user_user_id_seq OWNER TO postgres;

--
-- Name: m_user_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.m_user_user_id_seq OWNED BY public.m_user.user_id;


--
-- Name: t_transaksi; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_transaksi (
    tanggal date,
    kode character varying(16),
    produk character varying(10),
    harga_satuan numeric,
    kuantitas numeric
);


ALTER TABLE public.t_transaksi OWNER TO postgres;

--
-- Name: m_user user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.m_user ALTER COLUMN user_id SET DEFAULT nextval('public.m_user_user_id_seq'::regclass);


--
-- Data for Name: m_nasabah; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.m_nasabah (kode, nama) FROM stdin;
CL001	Nana
CL002	Dewa Buana
CL003	Lula
CL004	Livia Putri
CL005	Roni Hermawan
CL006	Pasha Bayu
\.


--
-- Data for Name: m_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.m_user (user_id, user_name, user_address) FROM stdin;
1	M. Ilyas Tri Khaqiqi	Bandung, Indonesia.
\.


--
-- Data for Name: m_user_office; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.m_user_office (nid, office_id) FROM stdin;
10	3
\.


--
-- Data for Name: t_transaksi; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.t_transaksi (tanggal, kode, produk, harga_satuan, kuantitas) FROM stdin;
2024-01-01	CL001	AA	2500	300
2024-01-01	CL003	AA	2500	200
2024-01-01	CL004	AA	2300	500
2024-01-01	CL005	AA	2400	500
2024-01-01	CL006	AA	2300	700
2024-01-01	CL001	BB	500	200
2024-01-01	CL005	BB	500	200
2024-02-01	CL001	AA	2500	200
2024-02-01	CL002	AA	2500	3000
2024-02-01	CL003	AA	2500	100
2024-02-01	CL004	AA	2500	500
2024-02-01	CL005	AA	2500	400
2024-02-01	CL005	BB	450	100
2024-02-01	CL001	BB	450	100
2024-03-01	CL001	AA	2400	500
2024-03-01	CL002	AA	2400	500
2024-04-01	CL001	AA	2000	500
2024-04-01	CL003	AA	2000	500
2024-04-01	CL004	AA	2000	500
2024-01-01	CL002	AA	2400	1000
\.


--
-- Name: m_user_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.m_user_user_id_seq', 3, true);


--
-- Name: m_nasabah m_nasabah_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.m_nasabah
    ADD CONSTRAINT m_nasabah_pk PRIMARY KEY (kode);


--
-- Name: m_user m_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.m_user
    ADD CONSTRAINT m_user_pkey PRIMARY KEY (user_id);


--
-- Name: t_transaksi t_transaksi_m_nasabah_kode_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_transaksi
    ADD CONSTRAINT t_transaksi_m_nasabah_kode_fk FOREIGN KEY (kode) REFERENCES public.m_nasabah(kode);


--
-- PostgreSQL database dump complete
--

