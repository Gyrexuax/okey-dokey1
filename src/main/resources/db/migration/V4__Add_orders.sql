INSERT INTO orders (id, address, city, date, email, first_name, last_name, phone_number, post_index, total_price, user_id)
    VALUES (1, 'Wall Street1', 'New York', '2024-04-07', 'test123@test.com', 'John', 'Smith', '1234567890', 1234567890, 110, 2);
INSERT INTO orders (id, address, city, date, email, first_name, last_name, phone_number, post_index, total_price, user_id)
    VALUES (2, 'Wall Street1', 'New York', '2024-04-07', 'test123@test.com', 'John', 'Smith', '1234567890', 1234567890, 160, 2);
INSERT INTO orders (id, address, city, date, email, first_name, last_name, phone_number, post_index, total_price, user_id)
    VALUES (3, 'Bandera street 1', 'Dnipro', '2024-04-07', 'ivan123@test.com', 'Ivan', 'Shevchenko', '1234567890', 1234567890, 260, 3);
INSERT INTO orders (id, address, city, date, email, first_name, last_name, phone_number, post_index, total_price, user_id)
    VALUES (4, 'Bandera street 1', 'Dnipro', '2024-04-07', 'ivan123@test.com', 'Ivan', 'Shevchenko', '1234567890', 1234567890, 90, 3);
INSERT INTO orders (id, address, city, date, email, first_name, last_name, phone_number, post_index, total_price, user_id)
    VALUES (5, 'Bandera street 1', 'Dnipro', '2024-04-07', 'ivan123@test.com', 'Ivan', 'Shevchenko', '1234567890', 1234567890, 90, 3);

INSERT INTO orders_clothes (order_id, clothes_id) VALUES (1, 33);
INSERT INTO orders_clothes (order_id, clothes_id) VALUES (1, 34);
INSERT INTO orders_clothes (order_id, clothes_id) VALUES (2, 39);
INSERT INTO orders_clothes (order_id, clothes_id) VALUES (2, 43);
INSERT INTO orders_clothes (order_id, clothes_id) VALUES (3, 65);
INSERT INTO orders_clothes (order_id, clothes_id) VALUES (3, 59);
INSERT INTO orders_clothes (order_id, clothes_id) VALUES (3, 1);
INSERT INTO orders_clothes (order_id, clothes_id) VALUES (4, 16);
INSERT INTO orders_clothes (order_id, clothes_id) VALUES (4, 17);
INSERT INTO orders_clothes (order_id, clothes_id) VALUES (5, 33);
INSERT INTO orders_clothes (order_id, clothes_id) VALUES (5, 38);
