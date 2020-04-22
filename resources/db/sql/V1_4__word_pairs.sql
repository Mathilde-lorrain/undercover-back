CREATE TABLE public.word_pairs
(
    id                BIGSERIAL PRIMARY KEY,
    word1       VARCHAR,
    word2   VARCHAR
);

ALTER SEQUENCE word_pairs_id_seq START 100 INCREMENT BY 50;
