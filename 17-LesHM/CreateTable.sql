-- Новый скрипт в Postgre - [localhost].
-- Дата: 2 дек. 2022 г.
-- Время: 18:42:39

CREATE TABLE public.answers (
    id int NOT NULL,
    id_question int NOT NULL,
    answer varchar NOT NULL,
    correct bool DEFAULT FALSE,
    date_create date NOT NULL,
    date_lastedit date,
    deleted bool DEFAULT FALSE NOT NULL, 
    CONSTRAINT answers_pk PRIMARY KEY (id),
	CONSTRAINT answers_un UNIQUE (id)    
);

ALTER TABLE public.answers OWNER TO test2;

CREATE TABLE public.category (
    id int NOT NULL,
    category varchar NOT NULL,
    date_create date NOT NULL,
    date_lastedit date,    
    deleted bool DEFAULT false NOT NULL,
    CONSTRAINT category_pk PRIMARY KEY (id),
	CONSTRAINT category_un UNIQUE (id)     
);

ALTER TABLE public.category OWNER TO test2;

CREATE TABLE public.questions (
    id int NOT NULL,
    question varchar NOT NULL,
    category int NOT NULL DEFAULT 1,
    date_create date NOT NULL,
    date_lastedit date,
    deleted bool DEFAULT false NOT NULL,
    CONSTRAINT questions_pk PRIMARY KEY (id),
	CONSTRAINT questions_un UNIQUE (id)
);

ALTER TABLE public.questions OWNER TO test2;

ALTER TABLE ONLY public.questions ADD CONSTRAINT questions_answer_fk FOREIGN KEY (id) REFERENCES public.answers(id);
ALTER TABLE ONLY public.questions ADD CONSTRAINT questions_category_fk FOREIGN KEY (category) REFERENCES public.category(id);



