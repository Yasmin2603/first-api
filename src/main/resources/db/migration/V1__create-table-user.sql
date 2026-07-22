CREATE TABLE users(
                      id TEXT PRIMARY KEY NOT NULL,
                      name TEXT NOT NULL,
                      email TEXT NOT NULL,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);