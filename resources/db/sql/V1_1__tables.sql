CREATE TABLE public.game
(
  id        BIGSERIAL PRIMARY KEY,
  status    VARCHAR NOT NULL
);

CREATE TABLE public.user
(
  id          BIGSERIAL PRIMARY KEY,
  name        VARCHAR UNIQUE NOT NULL,
  password    VARCHAR NOT NULL
);

CREATE TABLE public.role
(
    id BIGSERIAL PRIMARY KEY,
    user_id   BIGINT NOT NULL REFERENCES user(id),
    game_id     BIGINT NOT NULL REFERENCES game(id),
    role_type   VARCHAR NOT NULL,
    alive       BOOLEAN
);

CREATE TABLE public.turn
(
  id                BIGSERIAL   PRIMARY KEY,
  game_id           BIGINT      NOT NULL REFERENCES game(id),
  turn_number       INT         NOT NULL,
  killed_player_id  BIGINT      NULL REFERENCES role(id)
);

CREATE TABLE public.vote
(
    id          BIGINT PRIMARY KEY,
    turn_id     BIGINT NOT NULL REFERENCES turn(id),
    voter_id   BIGINT NOT NULL REFERENCES role(id),
    target_id   BIGINT NOT NULL REFERENCES role(id)
);

CREATE TABLE public.word
(
    id          BIGINT PRIMARY KEY,
    turn_id     BIGINT NOT NULL REFERENCES turn(id),
    role_id   BIGINT NOT NULL REFERENCES role(id),
    word        VARCHAR NOT NULL
);

ALTER SEQUENCE game_id_seq INCREMENT BY 50;
ALTER SEQUENCE turn_id_seq INCREMENT BY 50;
ALTER SEQUENCE user_id_seq INCREMENT BY 50;
ALTER SEQUENCE role_id_seq INCREMENT BY 50;
ALTER SEQUENCE word_id_seq INCREMENT BY 50;
ALTER SEQUENCE vote_id_seq INCREMENT BY 50;
