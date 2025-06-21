-- Thêm các danh mục sản phẩm vào bảng categories
INSERT INTO categories (img, name)
VALUES
    ('https://img.icons8.com/?size=100&id=2884&format=png&color=000000', 'Laptop'),
    ('https://img.icons8.com/?size=100&id=39210&format=png&color=000000', 'Màn hình'),
    ('https://codia-f2c.s3.us-west-1.amazonaws.com/image/2025-05-10/QZSApLBh7o.png', 'Tai nghe'),
    ('https://img.icons8.com/?size=100&id=4ujv4iKwcxVM&format=png&color=000000', 'PC GVN'),
    ('https://img.icons8.com/?size=100&id=1938&format=png&color=000000', 'Main'),
    ('https://img.icons8.com/?size=100&id=178&format=png&color=000000', 'Ổ cứng'),
    ('https://img.icons8.com/?size=100&id=111350&format=png&color=000000', 'Loa, Micro, Webcam'),
    ('https://img.icons8.com/?size=100&id=9095&format=png&color=000000', 'CPU'),
    ('https://codia-f2c.s3.us-west-1.amazonaws.com/image/2025-05-10/b7fd1ad4-7469-4762-875b-210805ca2464.png', 'Bàn phím'),
    ('https://codia-f2c.s3.us-west-1.amazonaws.com/image/2025-05-10/8dq5z4APHa.png', 'Dịch vụ custom');


-- Thêm sản phẩm Laptop Dell XPS
INSERT INTO products (id, name, img, price, original_price, discount, description, in_stock, product_new, type, category_id, featured, hot) VALUES
                                                                                                                                                (1, 'Laptop Dell XPS 13', 'https://ngocnguyen.vn/cdn/images/202304/goods_img/dell-xps-9305-i7-1165g7-ram-8gb-ssd-256gb-133-inch-fhd-G7699-1681201741775.jpg', 30000000, 32000000, '6%', 'Laptop cao cấp, màn hình 13 inch Full HD.', true, true, 'Laptop', 1, 1, 1),
                                                                                                                                                (2, 'Laptop MacBook Air M2', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/v/n/vn0d33_1.jpg', 29000000, 31000000, '6%', 'MacBook siêu nhẹ dùng chip Apple M2.', true, true, 'Laptop', 1, 1, 1),
                                                                                                                                                (3, 'Laptop HP Pavilion 14', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/l/a/laptop_hp_pavilion_x360_14-ek2017tu_9z2v5pa_-_2.png', 15000000, 16000000, '6%', 'Laptop học sinh, sinh viên cấu hình ổn.', true, false, 'Laptop', 1, 0, 1),
                                                                                                                                                (4, 'Laptop Asus ZenBook', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/a/s/asus-zenbook-14-oled-ux3405ma-ultra-5-pp151w-3.jpg', 18000000, 19000000, '6%', 'Mỏng nhẹ, pin lâu, màn hình OLED.', true, true, 'Laptop', 1, 0, 0),
                                                                                                                                                (5, 'Laptop Lenovo ThinkPad', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/e/text_ng_n_16__6_169.png', 25000000, 27000000, '6%', 'Dòng máy doanh nhân siêu bền.', true, false, 'Laptop', 1, 1, 0);

INSERT INTO products (id, name, img, price, original_price, discount, description, in_stock, product_new, type, category_id, featured, hot) VALUES
-- màn hình
(6, 'Màn hình LG UltraGear 144Hz', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/a/man-hinh-gaming-lg-ultragear-24gs50f-b-24-inch.png', 5200000, 5700000, '10%', 'Màn hình chơi game tần số quét cao.', true, true, 'Màn hình', 2, 1, 1),
(7, 'Màn hình Dell UltraSharp 24"', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_179_16_.png', 4900000, 5400000, '10%', 'Màn hình đồ họa chất lượng cao.', true, true, 'Màn hình', 2, 1, 0),
(8, 'Màn hình Samsung Curve 27"', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/e/text_ng_n_48__3_12.png', 5900000, 6500000, '10%', 'Màn hình cong Full HD siêu rộng.', true, false, 'Màn hình', 2, 0, 1),
(9, 'Màn hình Asus ProArt', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/_/m_n_h_nh_chuy_n_ho_asus_24_proart_pa248qv_0003_layer_1.jpg', 6700000, 7400000, '10%', 'Phù hợp thiết kế, màu chuẩn xác.', true, true, 'Màn hình', 2, 1, 1),
(10, 'Màn hình MSI Optix MAG', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/m/image_-_2024-12-25t194047.227_1.png', 5200000, 5700000, '10%', 'Màn hình chơi game góc rộng.', true, false, 'Màn hình', 2, 0, 0),

-- tai nghe
(11, 'Tai nghe Sony WH-1000XM4', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_17333.png', 5500000, 6000000, '10%', 'Chống ồn chủ động, âm thanh cao cấp.', true, true, 'Tai nghe', 3, 1, 1),
(12, 'Tai nghe AirPods Pro 2', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/a/p/apple-airpods-pro-2-usb-c-ksp-1_3_.png', 6000000, 6700000, '10%', 'Tai nghe không dây Apple.', true, true, 'Tai nghe', 3, 1, 0),
(13, 'Tai nghe JBL Tune 510BT', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/j/b/jbl-quantum-400.jpg', 1100000, 1300000, '10%', 'Bluetooth 5.0, pin lâu.', true, false, 'Tai nghe', 3, 0, 1),
(14, 'Tai nghe Logitech G733', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/a/tai-nghe-chup-tai-logitech-rgb-g733-5.png', 2900000, 3200000, '10%', 'Gaming RGB không dây.', true, true, 'Tai nghe', 3, 1, 1),
(15, 'Tai nghe Razer Kraken X', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/a/tai-nghe-chup-tai-co-day-razer-blackshark-v2-x-3-5mm_3_.png', 1950000, 2200000, '10%', 'Gaming 7.1, khung nhẹ.', true, false, 'Tai nghe', 3, 0, 0),

-- pc gvn
(16, 'PC GVN Gaming A Ryzen 5', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/1/-/1-96_1_7.png', 15000000, 16500000, '10%', 'PC chơi game cấu hình mạnh, Ryzen 5 + GTX 1660.', true, true, 'PC', 4, 1, 1),
(17, 'PC GVN Workstation i7', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_786_2_.png', 22000000, 24000000, '10%', 'PC cho dân thiết kế, dựng hình, render.', true, true, 'PC', 4, 1, 0),
(18, 'PC GVN Streamer Pro', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/e/text_ng_n_12__7_4_3.png', 18500000, 20000000, '10%', 'Cấu hình stream mượt, ổn định.', true, false, 'PC', 4, 1, 1),
(19, 'PC GVN Budget i3', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_786.png', 9500000, 10500000, '10%', 'PC giá rẻ học tập văn phòng.', true, true, 'PC', 4, 0, 1),
(20, 'PC GVN Gaming RTX', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_555_1_.png', 28000000, 31000000, '10%', 'PC cao cấp dùng card RTX 3060Ti.', true, false, 'PC', 4, 1, 0),

-- main
(21, 'Mainboard MSI B550 TOMAHAWK', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/j/_/j.png', 3500000, 3850000, '10%', 'Main hỗ trợ Ryzen, chuẩn ATX.', true, true, 'Main', 5, 1, 1),
(22, 'Mainboard ASUS TUF Z590', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/a/mainboard-asus-tuf-gaming-z890-pro-wifi_1_.png', 4300000, 4700000, '10%', 'Hỗ trợ Intel Gen 11, cực bền.', true, true, 'Main', 5, 1, 0),
(23, 'Mainboard Gigabyte B460M', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/a/mainboard-gigabyte-b460m-ds3h-v2_1.jpg', 2700000, 3000000, '10%', 'Main mATX cho Intel Gen 10.', true, false, 'Main', 5, 0, 1),
(24, 'Mainboard ASRock X570 Steel Legend', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_632.png', 4000000, 4400000, '10%', 'Main hỗ trợ PCIe 4.0 Ryzen.', true, true, 'Main', 5, 1, 1),
(25, 'Mainboard Biostar B450MH', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/a/mainboard-asrock-b450m-hdv-r4-00.png', 1950000, 2150000, '10%', 'Main cơ bản cho Ryzen 3/5.', true, false, 'Main', 5, 0, 0),

-- ổ cứng
(26, 'Ổ cứng SSD Samsung 970 EVO 500GB', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/2/_/2_150.png', 2300000, 2550000, '10%', 'Chuẩn NVMe tốc độ cao.', true, true, 'SSD', 6, 1, 1),
(27, 'Ổ cứng HDD WD Blue 1TB', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/_/t_i_xu_ng_-_2023-01-28t224540.685.png', 1200000, 1350000, '10%', 'Dung lượng lớn, lưu trữ ổn định.', true, true, 'HDD', 6, 0, 1),
(28, 'Ổ cứng SSD Kingston A400 240GB', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/3/_/3.u2409.d20170421.t141838.551269_1.jpg', 850000, 950000, '10%', 'Giá rẻ, tốc độ ổn.', true, false, 'SSD', 6, 0, 0),
(29, 'Ổ cứng SSD Crucial MX500 1TB', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/_/0/_0001_51541_ssd_seagate_barracuda_120_1__1.jpg', 2700000, 3000000, '10%', 'Tốc độ đọc ghi cao, bền.', true, true, 'SSD', 6, 1, 1),
(30, 'Ổ cứng Seagate Barracuda 2TB', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/_/0/_0000_58203_o_cung_ssd_seagate_barracu.jpg', 1550000, 1700000, '10%', 'Dùng cho lưu trữ phim, backup.', true, false, 'HDD', 6, 1, 0),

-- loa, micro, webcam
(31, 'Webcam Logitech C920 HD', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/w/e/webcam-logitech-c920-hd-1.jpg', 1350000, 1500000, '10%', 'Webcam chất lượng cao Full HD.', true, true, 'Webcam', 7, 1, 1),
(32, 'Micro Razer Seiren Mini', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/j/b/jbl-partybox-encore-2.jpg', 990000, 1100000, '10%', 'Thu âm tốt, thiết kế nhỏ gọn.', true, true, 'Micro', 7, 0, 1),
(33, 'Micro Blue Yeti X', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/w/e/webcam-tich-hop-micro-genius-facecam-2000x-1080p-30fps_2_.png', 3200000, 3550000, '10%', 'Thu âm chuyên nghiệp cho stream.', true, false, 'Micro', 7, 1, 1),
(34, 'Loa JBL GO 3', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/j/b/jbl_go_3_11.png', 780000, 850000, '10%', 'Loa Bluetooth nhỏ gọn, pin tốt.', true, false, 'Loa', 7, 0, 0),
(35, 'Micro Sony ECM', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/i/microphone-co-day-saramonic-sr-mv2000.png', 1450000, 1600000, '10%', 'Micro chuyên dùng máy ảnh.', true, true, 'Micro', 7, 1, 0),

-- cpu
(36, 'CPU Intel Core i7 12700K', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_208_1.png', 8500000, 9350000, '10%', '12 nhân, hiệu suất mạnh.', true, true, 'CPU', 8, 1, 1),
(37, 'CPU AMD Ryzen 5 5600X', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/_/t_i_xu_ng_-_2023-01-02t221507.270_2.png', 5600000, 6200000, '10%', '6 nhân 12 luồng.', true, true, 'CPU', 8, 1, 1),
(38, 'CPU Intel Core i5 12400F', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/1/_/1.10.png', 4200000, 4600000, '10%', 'Giá tốt cho gaming.', true, false, 'CPU', 8, 0, 1),
(39, 'CPU Ryzen 9 7900X', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_314_8_.png', 9800000, 10700000, '10%', 'CPU cao cấp cho render.', true, true, 'CPU', 8, 1, 1),
(40, 'CPU Intel Xeon E5', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_251_1__1_2.png', 4500000, 4950000, '10%', 'Dùng cho máy trạm.', true, false, 'CPU', 8, 0, 0),

-- bàn phím
(41, 'Bàn phím Keychron K2', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/b/a/ban-phim-keychron-k8-1.png', 1700000, 1900000, '10%', 'Cơ bluetooth 75% hot swap.', true, true, 'Bàn phím', 9, 1, 1),
(42, 'Bàn phím Logitech K380', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/b/a/ban-phim-bluetooth-logitech-pebble-k380s-12.png', 700000, 770000, '10%', 'Bluetooth mini, 3 thiết bị.', true, true, 'Bàn phím', 9, 0, 1),
(43, 'Bàn phím Razer BlackWidow', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/b/a/ban-phim-co-razer-blackwidow-v3-yellow-switch.png', 2200000, 2500000, '10%', 'Switch cơ chính hãng Razer.', true, false, 'Bàn phím', 9, 1, 1),
(44, 'Bàn phím Corsair K70 RGB', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/f/r/frame_379_-_2025-05-16t111644.812.png', 2900000, 3200000, '10%', 'RGB, chống ghost, chơi game.', true, true, 'Bàn phím', 9, 1, 1),
(45, 'Bàn phím DareU EK87', 'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/b/a/ban-phim-co-khong-day-dareu-ek87-pro-proto-2.png', 890000, 980000, '10%', 'Cơ giá rẻ, đầy đủ tính năng.', true, false, 'Bàn phím', 9, 0, 0);


INSERT INTO specifications (name, category_id) VALUES
                                                   ('CPU', 1),
                                                   ('RAM', 1),
                                                   ('Ổ cứng', 1),
                                                   ('Màn hình', 1),
                                                   ('Card màn hình', 1),
                                                   ('Bàn phím', 1),
                                                   ('Cổng kết nối', 1),
                                                   ('Bảo mật', 1),
                                                   ('Webcam', 1),
                                                   ('Audio', 1),
                                                   ('Kết nối không dây', 1),
                                                   ('Pin', 1),
                                                   ('Hệ điều hành', 1),
                                                   ('Màu sắc', 1),
                                                   ('Trọng lượng', 1),
                                                   ('Kích thước', 1),
                                                   ('Chất liệu vỏ', 1),
                                                   ('Bluetooth', 1),
                                                   ('LAN', 1),
                                                   ('Wireless', 1),
                                                   ('Cổng giao tiếp', 1),
                                                   ('Card đồ họa', 1);

INSERT INTO specifications (name, category_id) VALUES
                                                   ('Kích thước', 2),
                                                   ('Tấm nền', 2),
                                                   ('Tần số quét', 2),
                                                   ('Độ phân giải', 2),
                                                   ('Tỷ lệ màn hình', 2),
                                                   ('Thời gian phản hồi', 2),
                                                   ('Độ sáng', 2),
                                                   ('Cổng kết nối', 2),
                                                   ('Công nghệ HDR', 2),
                                                   ('Phù hợp gaming', 2);

INSERT INTO specifications (name, category_id) VALUES
                                                   ('Kiểu tai nghe', 3),
                                                   ('Kết nối', 3),
                                                   ('Tính năng nổi bật', 3),
                                                   ('Thời lượng pin', 3),
                                                   ('Tần số phản hồi', 3),
                                                   ('Độ nhạy', 3),
                                                   ('Trở kháng', 3),
                                                   ('Microphone', 3),
                                                   ('Khả năng chống ồn', 3),
                                                   ('Khối lượng', 3);

INSERT INTO specifications (name, category_id) VALUES
                                                   ('CPU', 4),
                                                   ('Mainboard', 4),
                                                   ('RAM', 4),
                                                   ('Ổ cứng SSD', 4),
                                                   ('Ổ cứng HDD', 4),
                                                   ('Card đồ họa', 4),
                                                   ('Nguồn', 4),
                                                   ('Case', 4),
                                                   ('Tản nhiệt', 4),
                                                   ('Hệ điều hành', 4);

INSERT INTO specifications (name, category_id) VALUES
                                                   ('Socket', 5),
                                                   ('Chipset', 5),
                                                   ('Kích thước', 5),
                                                   ('Số khe RAM', 5),
                                                   ('Kết nối', 5),
                                                   ('Cổng mở rộng', 5),
                                                   ('USB', 5),
                                                   ('Âm thanh', 5);

INSERT INTO specifications (name, category_id) VALUES
                                                   ('Loại ổ', 6),
                                                   ('Dung lượng', 6),
                                                   ('Tốc độ đọc', 6),
                                                   ('Tốc độ ghi', 6),
                                                   ('Chuẩn kết nối', 6),
                                                   ('Bộ nhớ cache', 6),
                                                   ('Kích thước', 6);

INSERT INTO specifications (name, category_id) VALUES
                                                   ('Loại thiết bị', 7),
                                                   ('Kết nối', 7),
                                                   ('Độ phân giải webcam', 7),
                                                   ('Tần số Micro', 7),
                                                   ('Số lượng mic', 7),
                                                   ('Tính năng đặc biệt', 7);

INSERT INTO specifications (name, category_id) VALUES
                                                   ('Socket', 8),
                                                   ('Số nhân', 8),
                                                   ('Số luồng', 8),
                                                   ('Xung nhịp cơ bản', 8),
                                                   ('Xung nhịp tối đa', 8),
                                                   ('Bộ nhớ đệm', 8),
                                                   ('TDP', 8),
                                                   ('Công nghệ tích hợp', 8);

INSERT INTO specifications (name, category_id) VALUES
                                                   ('Kiểu switch', 9),
                                                   ('Layout', 9),
                                                   ('Kết nối', 9),
                                                   ('LED RGB', 9),
                                                   ('Chống nước', 9),
                                                   ('Kích thước', 9),
                                                   ('Chất liệu', 9);

-- Laptop Dell XPS 13
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (1, 1, 'Intel Core i7-1165G7'),
                                                                             (1, 2, '8GB LPDDR4x'),
                                                                             (1, 3, '256GB SSD'),
                                                                             (1, 4, '13.3 inch Full HD'),
                                                                             (1, 5, 'Intel Iris Xe Graphics'),
                                                                             (1, 6, 'Backlit Keyboard'),
                                                                             (1, 7, '2 x Thunderbolt 4, 1 x 3.5mm Audio'),
                                                                             (1, 8, 'Vân tay'),
                                                                             (1, 9, '720p HD Webcam'),
                                                                             (1, 10, 'Loa stereo Waves MaxxAudio'),
                                                                             (1, 11, 'Wi-Fi 6, Bluetooth 5.1'),
                                                                             (1, 12, '4-cell 52Wh'),
                                                                             (1, 13, 'Windows 11 Home'),
                                                                             (1, 14, 'Bạc'),
                                                                             (1, 15, '1.2kg'),
                                                                             (1, 16, '295.7 x 198.7 x 14.8 mm'),
                                                                             (1, 17, 'Nhôm nguyên khối'),
                                                                             (1, 18, 'Bluetooth 5.1'),
                                                                             (1, 19, 'Không hỗ trợ'),
                                                                             (1, 20, 'Wi-Fi 6'),
                                                                             (1, 21, '2 x Thunderbolt 4'),
                                                                             (1, 22, 'Intel Iris Xe Graphics');

-- Laptop MacBook Air M2
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (2, 1, 'Apple M2'),
                                                                             (2, 2, '8GB Unified RAM'),
                                                                             (2, 3, '256GB SSD'),
                                                                             (2, 4, '13.6 inch Liquid Retina'),
                                                                             (2, 5, 'GPU 8 nhân'),
                                                                             (2, 6, 'Magic Keyboard có Touch ID'),
                                                                             (2, 7, '2 x Thunderbolt / USB 4'),
                                                                             (2, 8, 'Touch ID'),
                                                                             (2, 9, '1080p FaceTime HD'),
                                                                             (2, 10, 'Hệ thống loa 4 chiều'),
                                                                             (2, 11, 'Wi-Fi 6, Bluetooth 5.0'),
                                                                             (2, 12, '52.6Wh'),
                                                                             (2, 13, 'macOS'),
                                                                             (2, 14, 'Xám'),
                                                                             (2, 15, '1.24kg'),
                                                                             (2, 16, '304.1 x 215 x 11.3 mm'),
                                                                             (2, 17, 'Nhôm nguyên khối'),
                                                                             (2, 18, 'Bluetooth 5.0'),
                                                                             (2, 19, 'Không hỗ trợ'),
                                                                             (2, 20, 'Wi-Fi 6'),
                                                                             (2, 21, '2 x Thunderbolt / USB 4'),
                                                                             (2, 22, 'GPU 8 nhân Apple M2');

-- Laptop HP Pavilion 14
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (3, 1, 'Intel Core i5-1235U'),
                                                                             (3, 2, '8GB DDR4'),
                                                                             (3, 3, '512GB SSD'),
                                                                             (3, 4, '14 inch FHD IPS'),
                                                                             (3, 5, 'Intel Iris Xe Graphics'),
                                                                             (3, 6, 'Standard Keyboard'),
                                                                             (3, 7, 'HDMI, USB Type-C, USB 3.1'),
                                                                             (3, 8, 'Không có'),
                                                                             (3, 9, 'HD Webcam'),
                                                                             (3, 10, 'Dual speakers, B&O'),
                                                                             (3, 11, 'Wi-Fi 6, Bluetooth 5.2'),
                                                                             (3, 12, '3-cell 41Wh'),
                                                                             (3, 13, 'Windows 11 Home'),
                                                                             (3, 14, 'Bạc'),
                                                                             (3, 15, '1.41kg'),
                                                                             (3, 16, '325 x 216 x 17.9 mm'),
                                                                             (3, 17, 'Nhựa và kim loại'),
                                                                             (3, 18, 'Bluetooth 5.2'),
                                                                             (3, 19, 'Không hỗ trợ'),
                                                                             (3, 20, 'Wi-Fi 6'),
                                                                             (3, 21, '1 x USB Type-C, 2 x USB Type-A, 1 x HDMI'),
                                                                             (3, 22, 'Intel Iris Xe Graphics');

-- Laptop Asus ZenBook
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (4, 1, 'Intel Core Ultra 5 125H'),
                                                                             (4, 2, '16GB LPDDR5x'),
                                                                             (4, 3, '512GB SSD'),
                                                                             (4, 4, '14 inch 2.8K OLED'),
                                                                             (4, 5, 'Intel Graphics'),
                                                                             (4, 6, 'Backlit Keyboard'),
                                                                             (4, 7, 'USB-C, HDMI, USB 3.2'),
                                                                             (4, 8, 'Vân tay'),
                                                                             (4, 9, 'FHD IR Camera'),
                                                                             (4, 10, 'Harman Kardon'),
                                                                             (4, 11, 'Wi-Fi 6E, Bluetooth 5.3'),
                                                                             (4, 12, '75Wh'),
                                                                             (4, 13, 'Windows 11 Home'),
                                                                             (4, 14, 'Xanh dương'),
                                                                             (4, 15, '1.2kg'),
                                                                             (4, 16, '313 x 220 x 15 mm'),
                                                                             (4, 17, 'Nhôm CNC'),
                                                                             (4, 18, 'Bluetooth 5.3'),
                                                                             (4, 19, 'Không hỗ trợ'),
                                                                             (4, 20, 'Wi-Fi 6E'),
                                                                             (4, 21, '1 x HDMI, 2 x USB-C, 1 x USB-A'),
                                                                             (4, 22, 'Intel Graphics');

-- Laptop Lenovo ThinkPad
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (5, 1, 'Intel Core i7-1260P'),
                                                                             (5, 2, '16GB DDR4'),
                                                                             (5, 3, '512GB SSD'),
                                                                             (5, 4, '14 inch FHD IPS Anti-glare'),
                                                                             (5, 5, 'Intel Iris Xe Graphics'),
                                                                             (5, 6, 'ThinkPad Keyboard'),
                                                                             (5, 7, 'Thunderbolt 4, HDMI, USB 3.2'),
                                                                             (5, 8, 'Vân tay'),
                                                                             (5, 9, 'HD Webcam with Privacy Shutter'),
                                                                             (5, 10, 'Dolby Audio'),
                                                                             (5, 11, 'Wi-Fi 6E, Bluetooth 5.2'),
                                                                             (5, 12, '3-cell 57Wh'),
                                                                             (5, 13, 'Windows 11 Pro'),
                                                                             (5, 14, 'Đen'),
                                                                             (5, 15, '1.32kg'),
                                                                             (5, 16, '317 x 226 x 18.9 mm'),
                                                                             (5, 17, 'Sợi carbon và hợp kim'),
                                                                             (5, 18, 'Bluetooth 5.2'),
                                                                             (5, 19, 'Có cổng LAN'),
                                                                             (5, 20, 'Wi-Fi 6E'),
                                                                             (5, 21, '2 x Thunderbolt 4, 1 x HDMI, 2 x USB 3.2'),
                                                                             (5, 22, 'Intel Iris Xe Graphics');

-- Thông số sản phẩm màn hình
-- Màn hình LG UltraGear 144Hz (ID: 6)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (6, 23, '24 inch'),
                                                                             (6, 24, 'IPS'),
                                                                             (6, 25, '144Hz'),
                                                                             (6, 26, '1920x1080'),
                                                                             (6, 27, '16:9'),
                                                                             (6, 28, '1ms'),
                                                                             (6, 29, '300 nits'),
                                                                             (6, 30, 'HDMI, DisplayPort'),
                                                                             (6, 31, 'HDR10'),
                                                                             (6, 32, 'Có');

-- Màn hình Dell UltraSharp 24" (ID: 7)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (7, 23, '24 inch'),
                                                                             (7, 24, 'IPS'),
                                                                             (7, 25, '60Hz'),
                                                                             (7, 26, '1920x1200'),
                                                                             (7, 27, '16:10'),
                                                                             (7, 28, '5ms'),
                                                                             (7, 29, '350 nits'),
                                                                             (7, 30, 'HDMI, DisplayPort, USB-C'),
                                                                             (7, 31, 'Không'),
                                                                             (7, 32, 'Không');

-- Màn hình Samsung Curve 27" (ID: 8)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (8, 23, '27 inch'),
                                                                             (8, 24, 'VA'),
                                                                             (8, 25, '75Hz'),
                                                                             (8, 26, '1920x1080'),
                                                                             (8, 27, '16:9'),
                                                                             (8, 28, '4ms'),
                                                                             (8, 29, '250 nits'),
                                                                             (8, 30, 'HDMI, VGA'),
                                                                             (8, 31, 'Không'),
                                                                             (8, 32, 'Có');

-- Màn hình Asus ProArt (ID: 9)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (9, 23, '24.1 inch'),
                                                                             (9, 24, 'IPS'),
                                                                             (9, 25, '75Hz'),
                                                                             (9, 26, '1920x1200'),
                                                                             (9, 27, '16:10'),
                                                                             (9, 28, '5ms'),
                                                                             (9, 29, '300 nits'),
                                                                             (9, 30, 'DisplayPort, HDMI, USB Hub'),
                                                                             (9, 31, 'Không'),
                                                                             (9, 32, 'Không');

-- Màn hình MSI Optix MAG (ID: 10)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (10, 23, '24 inch'),
                                                                             (10, 24, 'IPS'),
                                                                             (10, 25, '165Hz'),
                                                                             (10, 26, '1920x1080'),
                                                                             (10, 27, '16:9'),
                                                                             (10, 28, '1ms'),
                                                                             (10, 29, '250 nits'),
                                                                             (10, 30, 'HDMI, DisplayPort'),
                                                                             (10, 31, 'HDR Ready'),
                                                                             (10, 32, 'Có');

-- Tai nghe Sony WH-1000XM4 (product_id = 11)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (11, 33, 'Over-ear'),
                                                                             (11, 34, 'Bluetooth 5.0'),
                                                                             (11, 35, 'Chống ồn chủ động'),
                                                                             (11, 36, '30 giờ'),
                                                                             (11, 37, '4Hz - 40kHz'),
                                                                             (11, 38, '105 dB'),
                                                                             (11, 39, '47 ohm'),
                                                                             (11, 40, 'Có'),
                                                                             (11, 41, 'Chống ồn chủ động'),
                                                                             (11, 42, '254g');

-- Tai nghe AirPods Pro 2 (product_id = 12)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (12, 33, 'In-ear'),
                                                                             (12, 34, 'Bluetooth 5.3'),
                                                                             (12, 35, 'Adaptive Transparency'),
                                                                             (12, 36, '6 giờ (24 giờ với hộp sạc)'),
                                                                             (12, 37, '20Hz - 20kHz'),
                                                                             (12, 38, '110 dB'),
                                                                             (12, 39, 'Không rõ'),
                                                                             (12, 40, 'Có'),
                                                                             (12, 41, 'Chống ồn chủ động'),
                                                                             (12, 42, '5.3g mỗi tai');

-- Tai nghe JBL Tune 510BT (product_id = 13)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (13, 33, 'On-ear'),
                                                                             (13, 34, 'Bluetooth 5.0'),
                                                                             (13, 35, 'Âm bass mạnh'),
                                                                             (13, 36, '40 giờ'),
                                                                             (13, 37, '20Hz - 20kHz'),
                                                                             (13, 38, '103.5 dB'),
                                                                             (13, 39, '32 ohm'),
                                                                             (13, 40, 'Không'),
                                                                             (13, 41, 'Không có'),
                                                                             (13, 42, '160g');

-- Tai nghe Logitech G733 (product_id = 14)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (14, 33, 'Over-ear'),
                                                                             (14, 34, 'Wireless LIGHTSPEED'),
                                                                             (14, 35, 'RGB, âm thanh vòm 7.1'),
                                                                             (14, 36, '29 giờ'),
                                                                             (14, 37, '20Hz - 20kHz'),
                                                                             (14, 38, '87.5 dB SPL/mW'),
                                                                             (14, 39, '39 ohm'),
                                                                             (14, 40, 'Có'),
                                                                             (14, 41, 'Không có'),
                                                                             (14, 42, '278g');

-- Tai nghe Razer Kraken X (product_id = 15)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (15, 33, 'Over-ear'),
                                                                             (15, 34, 'Jack 3.5mm'),
                                                                             (15, 35, 'Âm thanh 7.1, siêu nhẹ'),
                                                                             (15, 36, 'Có dây - không pin'),
                                                                             (15, 37, '12Hz - 28kHz'),
                                                                             (15, 38, '109 dB'),
                                                                             (15, 39, '32 ohm'),
                                                                             (15, 40, 'Có'),
                                                                             (15, 41, 'Không có'),
                                                                             (15, 42, '250g');

-- PC GVN Gaming A Ryzen 5 (product_id = 16)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (16, 43, 'AMD Ryzen 5 5600'),
                                                                             (16, 44, 'Main B550M'),
                                                                             (16, 45, '16GB DDR4'),
                                                                             (16, 46, 'SSD 512GB NVMe'),
                                                                             (16, 47, 'HDD 1TB'),
                                                                             (16, 48, 'GTX 1660 Super'),
                                                                             (16, 49, '600W 80 Plus'),
                                                                             (16, 50, 'Vỏ GVN RGB'),
                                                                             (16, 51, 'Tản nhiệt khí'),
                                                                             (16, 52, 'Windows 11 Home');

-- PC GVN Workstation i7 (product_id = 17)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (17, 43, 'Intel Core i7-12700'),
                                                                             (17, 44, 'Main Z690'),
                                                                             (17, 45, '32GB DDR5'),
                                                                             (17, 46, 'SSD 1TB NVMe'),
                                                                             (17, 47, 'HDD 2TB'),
                                                                             (17, 48, 'RTX 3060 12GB'),
                                                                             (17, 49, '750W 80 Plus Gold'),
                                                                             (17, 50, 'Vỏ CoolMaster X3'),
                                                                             (17, 51, 'Tản nhiệt nước AIO'),
                                                                             (17, 52, 'Windows 11 Pro');

-- PC GVN Streamer Pro (product_id = 18)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (18, 43, 'Intel Core i5-12400F'),
                                                                             (18, 44, 'Main B660M'),
                                                                             (18, 45, '16GB DDR4'),
                                                                             (18, 46, 'SSD 512GB NVMe'),
                                                                             (18, 47, 'HDD 1TB'),
                                                                             (18, 48, 'RTX 2060 Super'),
                                                                             (18, 49, '650W 80 Plus'),
                                                                             (18, 50, 'Vỏ Corsair 275R'),
                                                                             (18, 51, 'Tản nhiệt khí RGB'),
                                                                             (18, 52, 'Windows 11 Home');

-- PC GVN Budget i3 (product_id = 19)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (19, 43, 'Intel Core i3-10105F'),
                                                                             (19, 44, 'Main H510M'),
                                                                             (19, 45, '8GB DDR4'),
                                                                             (19, 46, 'SSD 256GB SATA'),
                                                                             (19, 47, 'HDD 500GB'),
                                                                             (19, 48, 'UHD Graphics 630'),
                                                                             (19, 49, '450W'),
                                                                             (19, 50, 'Case văn phòng'),
                                                                             (19, 51, 'Tản nhiệt stock'),
                                                                             (19, 52, 'Windows 10 Home');

-- PC GVN Gaming RTX (product_id = 20)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (20, 43, 'AMD Ryzen 7 5800X'),
                                                                             (20, 44, 'Main X570'),
                                                                             (20, 45, '32GB DDR4'),
                                                                             (20, 46, 'SSD 1TB NVMe'),
                                                                             (20, 47, 'HDD 2TB'),
                                                                             (20, 48, 'RTX 3060 Ti'),
                                                                             (20, 49, '850W 80 Plus Gold'),
                                                                             (20, 50, 'Case GVN Gaming RGB'),
                                                                             (20, 51, 'Tản nhiệt nước AIO RGB'),
                                                                             (20, 52, 'Windows 11 Pro');

-- Mainboard MSI B550 TOMAHAWK (ID: 21)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (21, 53, 'AM4'),
                                                                             (21, 54, 'B550'),
                                                                             (21, 55, 'ATX'),
                                                                             (21, 56, '4 khe DDR4'),
                                                                             (21, 57, 'LAN 2.5G, HDMI, DisplayPort'),
                                                                             (21, 58, '2 x PCIe x16, 2 x PCIe x1'),
                                                                             (21, 59, 'USB 3.2 Gen 2, USB 2.0'),
                                                                             (21, 60, 'Realtek ALC1200');

-- Mainboard ASUS TUF Z590 (ID: 22)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (22, 53, 'LGA 1200'),
                                                                             (22, 54, 'Z590'),
                                                                             (22, 55, 'ATX'),
                                                                             (22, 56, '4 khe DDR4'),
                                                                             (22, 57, 'LAN 2.5G, WiFi 6, HDMI'),
                                                                             (22, 58, '3 x PCIe x16, 2 x PCIe x1'),
                                                                             (22, 59, 'USB 3.2 Gen 2x2, USB 3.2 Gen 1'),
                                                                             (22, 60, 'Realtek ALC S1200A');

-- Mainboard Gigabyte B460M (ID: 23)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (23, 53, 'LGA 1200'),
                                                                             (23, 54, 'B460'),
                                                                             (23, 55, 'mATX'),
                                                                             (23, 56, '2 khe DDR4'),
                                                                             (23, 57, 'LAN 1G, HDMI, DVI'),
                                                                             (23, 58, '1 x PCIe x16, 2 x PCIe x1'),
                                                                             (23, 59, 'USB 3.2 Gen 1, USB 2.0'),
                                                                             (23, 60, 'Realtek ALC887');

-- Mainboard ASRock X570 Steel Legend (ID: 24)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (24, 53, 'AM4'),
                                                                             (24, 54, 'X570'),
                                                                             (24, 55, 'ATX'),
                                                                             (24, 56, '4 khe DDR4'),
                                                                             (24, 57, 'LAN Gigabit, HDMI, DisplayPort'),
                                                                             (24, 58, '2 x PCIe 4.0 x16, 3 x PCIe x1'),
                                                                             (24, 59, 'USB 3.2 Gen 2, USB-C'),
                                                                             (24, 60, 'Realtek ALC1220');

-- Mainboard Biostar B450MH (ID: 25)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (25, 53, 'AM4'),
                                                                             (25, 54, 'B450'),
                                                                             (25, 55, 'mATX'),
                                                                             (25, 56, '2 khe DDR4'),
                                                                             (25, 57, 'LAN 1G, HDMI, DVI'),
                                                                             (25, 58, '1 x PCIe x16, 2 x PCIe x1'),
                                                                             (25, 59, 'USB 3.1 Gen 1, USB 2.0'),
                                                                             (25, 60, 'Realtek ALC887');

-- Ổ cứng SSD Samsung 970 EVO 500GB (product_id = 26)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (26, 61, 'SSD'),
                                                                             (26, 62, '500GB'),
                                                                             (26, 63, '3,500 MB/s'),
                                                                             (26, 64, '2,300 MB/s'),
                                                                             (26, 65, 'NVMe PCIe 3.0 x4'),
                                                                             (26, 66, '512MB'),
                                                                             (26, 67, 'M.2 2280');

-- Ổ cứng HDD WD Blue 1TB (product_id = 27)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (27, 61, 'HDD'),
                                                                             (27, 62, '1TB'),
                                                                             (27, 63, '150 MB/s'),
                                                                             (27, 64, '150 MB/s'),
                                                                             (27, 65, 'SATA 3'),
                                                                             (27, 66, '64MB'),
                                                                             (27, 67, '3.5 inch');

-- Ổ cứng SSD Kingston A400 240GB (product_id = 28)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (28, 61, 'SSD'),
                                                                             (28, 62, '240GB'),
                                                                             (28, 63, '500 MB/s'),
                                                                             (28, 64, '350 MB/s'),
                                                                             (28, 65, 'SATA 3'),
                                                                             (28, 66, 'Không có'),
                                                                             (28, 67, '2.5 inch');

-- Ổ cứng SSD Crucial MX500 1TB (product_id = 29)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (29, 61, 'SSD'),
                                                                             (29, 62, '1TB'),
                                                                             (29, 63, '560 MB/s'),
                                                                             (29, 64, '510 MB/s'),
                                                                             (29, 65, 'SATA 3'),
                                                                             (29, 66, '256MB'),
                                                                             (29, 67, '2.5 inch');

-- Ổ cứng Seagate Barracuda 2TB (product_id = 30)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (30, 61, 'HDD'),
                                                                             (30, 62, '2TB'),
                                                                             (30, 63, '190 MB/s'),
                                                                             (30, 64, '190 MB/s'),
                                                                             (30, 65, 'SATA 3'),
                                                                             (30, 66, '256MB'),
                                                                             (30, 67, '3.5 inch');

-- Webcam Logitech C920 HD (product_id = 31)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (31, 68, 'Webcam'),
                                                                             (31, 69, 'USB 2.0'),
                                                                             (31, 70, '1080p Full HD'),
                                                                             (31, 71, 'Không áp dụng'),
                                                                             (31, 72, '1 mic tích hợp'),
                                                                             (31, 73, 'Tự động lấy nét, chống rung');

-- Micro Razer Seiren Mini (product_id = 32)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (32, 68, 'Microphone Condenser'),
                                                                             (32, 69, 'USB'),
                                                                             (32, 70, 'Không áp dụng'),
                                                                             (32, 71, '20Hz - 20kHz'),
                                                                             (32, 72, '1 mic'),
                                                                             (32, 73, 'Thiết kế nhỏ gọn, chống ồn');

-- Micro Blue Yeti X (product_id = 33)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (33, 68, 'Microphone Condenser'),
                                                                             (33, 69, 'USB'),
                                                                             (33, 70, 'Không áp dụng'),
                                                                             (33, 71, '20Hz - 20kHz'),
                                                                             (33, 72, '4 mic'),
                                                                             (33, 73, 'Chống ồn, đa hướng thu');

-- Loa JBL GO 3 (product_id = 34)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (34, 68, 'Loa Bluetooth'),
                                                                             (34, 69, 'Bluetooth 5.1'),
                                                                             (34, 70, 'Không áp dụng'),
                                                                             (34, 71, 'Không áp dụng'),
                                                                             (34, 72, 'Không áp dụng'),
                                                                             (34, 73, 'Chống nước IP67, pin 5 giờ');

-- Micro Sony ECM (product_id = 35)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (35, 68, 'Microphone Condenser có dây'),
                                                                             (35, 69, 'Jack 3.5mm'),
                                                                             (35, 70, 'Không áp dụng'),
                                                                             (35, 71, '50Hz - 16kHz'),
                                                                             (35, 72, '1 mic'),
                                                                             (35, 73, 'Chuyên dùng cho máy ảnh');

-- CPU Intel Core i7 12700K (product_id = 36)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (36, 74, 'LGA1700'),
                                                                             (36, 75, '12'),
                                                                             (36, 76, '20'),
                                                                             (36, 77, '3.6 GHz'),
                                                                             (36, 78, '5.0 GHz'),
                                                                             (36, 79, '25 MB'),
                                                                             (36, 80, '125 W'),
                                                                             (36, 81, 'Intel Turbo Boost');

-- CPU AMD Ryzen 5 5600X (product_id = 37)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (37, 74, 'AM4'),
                                                                             (37, 75, '6'),
                                                                             (37, 76, '12'),
                                                                             (37, 77, '3.7 GHz'),
                                                                             (37, 78, '4.6 GHz'),
                                                                             (37, 79, '32 MB'),
                                                                             (37, 80, '65 W'),
                                                                             (37, 81, 'Precision Boost');

-- CPU Intel Core i5 12400F (product_id = 38)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (38, 74, 'LGA1700'),
                                                                             (38, 75, '6'),
                                                                             (38, 76, '12'),
                                                                             (38, 77, '2.5 GHz'),
                                                                             (38, 78, '4.4 GHz'),
                                                                             (38, 79, '18 MB'),
                                                                             (38, 80, '65 W'),
                                                                             (38, 81, 'Turbo Boost');

-- CPU Ryzen 9 7900X (product_id = 39)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (39, 74, 'AM5'),
                                                                             (39, 75, '12'),
                                                                             (39, 76, '24'),
                                                                             (39, 77, '4.7 GHz'),
                                                                             (39, 78, '5.6 GHz'),
                                                                             (39, 79, '64 MB'),
                                                                             (39, 80, '170 W'),
                                                                             (39, 81, 'Precision Boost 2');

-- CPU Intel Xeon E5 (product_id = 40)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (40, 74, 'LGA2011'),
                                                                             (40, 75, '8'),
                                                                             (40, 76, '16'),
                                                                             (40, 77, '2.4 GHz'),
                                                                             (40, 78, '3.0 GHz'),
                                                                             (40, 79, '20 MB'),
                                                                             (40, 80, '95 W'),
                                                                             (40, 81, 'Turbo Boost');

-- Bàn phím Keychron K2 (product_id = 41)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (41, 82, 'Switch Gateron Brown'),
                                                                             (41, 83, '75% layout'),
                                                                             (41, 84, 'Bluetooth, USB-C'),
                                                                             (41, 85, 'Có'),
                                                                             (41, 86, '360 x 124 x 38 mm'),
                                                                             (41, 87, 'Nhôm và nhựa'),
                                                                             (41, 88, 'Không chống nước');

-- Bàn phím Logitech K380 (product_id = 42)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (42, 82, 'Membrane'),
                                                                             (42, 83, 'Compact'),
                                                                             (42, 84, 'Bluetooth 3 thiết bị'),
                                                                             (42, 85, 'Không'),
                                                                             (42, 86, '279 x 124 x 16 mm'),
                                                                             (42, 87, 'Nhựa'),
                                                                             (42, 88, 'Không chống nước');

-- Bàn phím Razer BlackWidow (product_id = 43)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (43, 82, 'Switch Razer Green'),
                                                                             (43, 83, 'Full-size'),
                                                                             (43, 84, 'USB có dây'),
                                                                             (43, 85, 'Có'),
                                                                             (43, 86, '440 x 138 x 38 mm'),
                                                                             (43, 87, 'Nhựa cao cấp'),
                                                                             (43, 88, 'Chống nước nhẹ');

-- Bàn phím Corsair K70 RGB (product_id = 44)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (44, 82, 'Switch Cherry MX Red'),
                                                                             (44, 83, 'Full-size'),
                                                                             (44, 84, 'USB có dây'),
                                                                             (44, 85, 'Có'),
                                                                             (44, 86, '440 x 165 x 39 mm'),
                                                                             (44, 87, 'Nhôm'),
                                                                             (44, 88, 'Chống nước');

-- Bàn phím DareU EK87 (product_id = 45)
INSERT INTO product_specifications (product_id, specification_id, value) VALUES
                                                                             (45, 82, 'Switch Blue'),
                                                                             (45, 83, 'TKL 87 phím'),
                                                                             (45, 84, 'USB có dây'),
                                                                             (45, 85, 'Không'),
                                                                             (45, 86, '355 x 125 x 35 mm'),
                                                                             (45, 87, 'Nhựa ABS'),
                                                                             (45, 88, 'Không chống nước');

INSERT INTO product_colors(id, color, product_id) VALUES
-- Tai nghe Sony WH-1000XM4 (id = 11)
(1, 'Black', 11),
(2, 'Silver', 11),
(3, 'White', 11),

-- Tai nghe AirPods Pro 2 (id = 12)
(4, 'White', 12),

-- Tai nghe JBL Tune 510BT (id = 13)
(5, 'Black', 13),
(6, 'Blue', 13),
(7, 'Red', 13),

-- Tai nghe Logitech G733 (id = 14)
(8, 'Black', 14),
(9, 'Purple', 14),
(10, 'White', 14),

-- Tai nghe Razer Kraken X (id = 15)
(11, 'Black', 15),
(12, 'Green', 15),

-- Webcam Logitech C920 HD (id = 31)
(13, 'Black', 31),

-- Micro Razer Seiren Mini (id = 32)
(14, 'Black', 32),

-- Micro Blue Yeti X (id = 33)
(15, 'Black', 33),
(16, 'White', 33),

-- Loa JBL GO 3 (id = 34)
(17, 'Black', 34),
(18, 'Blue', 34),
(19, 'Red', 34),

-- Micro Sony ECM (id = 35)
(20, 'Black', 35);

INSERT INTO product_colors(id, color, product_id) VALUES
-- Bàn phím Keychron K2 (id = 41)
(21, 'Black', 41),
(22, 'White', 41),
(23, 'Gray', 41),

-- Bàn phím Logitech K380 (id = 42)
(24, 'Black', 42),
(25, 'White', 42),
(26, 'Blue', 42),

-- Bàn phím Razer BlackWidow (id = 43)
(27, 'Black', 43),
(28, 'Green', 43),

-- Bàn phím Corsair K70 RGB (id = 44)
(29, 'Black', 44),

-- Bàn phím DareU EK87 (id = 45)
(30, 'Black', 45),
(31, 'White', 45);

CREATE TABLE IF NOT EXISTS posts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    status VARCHAR(50),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

INSERT INTO product_images (url, alt, product_id) VALUES ('https://ngocnguyen.vn/cdn/images/202304/goods_img/dell-xps-9305-i7-1165g7-ram-8gb-ssd-256gb-133-inch-fhd-G7699-1681201741775.jpg', 'Ảnh sản phẩm 1', 1);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/v/n/vn0d33_1.jpg', 'Ảnh sản phẩm 2', 2);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/l/a/laptop_hp_pavilion_x360_14-ek2017tu_9z2v5pa_-_2.png', 'Ảnh sản phẩm 3', 3);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/a/s/asus-zenbook-14-oled-ux3405ma-ultra-5-pp151w-3.jpg', 'Ảnh sản phẩm 4', 4);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/e/text_ng_n_16__6_169.png', 'Ảnh sản phẩm 5', 5);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/a/man-hinh-gaming-lg-ultragear-24gs50f-b-24-inch.png', 'Ảnh sản phẩm 6', 6);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_179_16_.png', 'Ảnh sản phẩm 7', 7);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/e/text_ng_n_48__3_12.png', 'Ảnh sản phẩm 8', 8);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/_/m_n_h_nh_chuy_n_ho_asus_24_proart_pa248qv_0003_layer_1.jpg', 'Ảnh sản phẩm 9', 9);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/m/image_-_2024-12-25t194047.227_1.png', 'Ảnh sản phẩm 10', 10);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_17333.png', 'Ảnh sản phẩm 11', 11);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/a/p/apple-airpods-pro-2-usb-c-ksp-1_3_.png', 'Ảnh sản phẩm 12', 12);

INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/j/b/jbl-quantum-400.jpg', 'Ảnh sản phẩm 13', 13);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/a/tai-nghe-chup-tai-logitech-rgb-g733-5.png', 'Ảnh sản phẩm 14', 14);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/a/tai-nghe-chup-tai-co-day-razer-blackshark-v2-x-3-5mm_3_.png', 'Ảnh sản phẩm 15', 15);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/1/-/1-96_1_7.png', 'Ảnh sản phẩm 16', 16);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_786_2_.png', 'Ảnh sản phẩm 17', 17);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/e/text_ng_n_12__7_4_3.png', 'Ảnh sản phẩm 18', 18);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_786.png', 'Ảnh sản phẩm 19', 19);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_555_1_.png', 'Ảnh sản phẩm 20', 20);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/j/_/j.png', 'Ảnh sản phẩm 21', 21);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/a/mainboard-asus-tuf-gaming-z890-pro-wifi_1_.png', 'Ảnh sản phẩm 22', 22);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/a/mainboard-gigabyte-b460m-ds3h-v2_1.jpg', 'Ảnh sản phẩm 23', 23);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_632.png', 'Ảnh sản phẩm 24', 24);


INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/a/mainboard-asrock-b450m-hdv-r4-00.png', 'Ảnh sản phẩm 25', 25);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/2/_/2_150.png', 'Ảnh sản phẩm 26', 26);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/_/t_i_xu_ng_-_2023-01-28t224540.685.png', 'Ảnh sản phẩm 27', 27);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/3/_/3.u2409.d20170421.t141838.551269_1.jpg', 'Ảnh sản phẩm 28', 28);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/_/0/_0001_51541_ssd_seagate_barracuda_120_1__1.jpg', 'Ảnh sản phẩm 29', 29);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/_/0/_0000_58203_o_cung_ssd_seagate_barracu.jpg', 'Ảnh sản phẩm 30', 30);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/w/e/webcam-logitech-c920-hd-1.jpg', 'Ảnh sản phẩm 31', 31);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/j/b/jbl-partybox-encore-2.jpg', 'Ảnh sản phẩm 32', 32);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/w/e/webcam-tich-hop-micro-genius-facecam-2000x-1080p-30fps_2_.png', 'Ảnh sản phẩm 33', 33);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/j/b/jbl_go_3_11.png', 'Ảnh sản phẩm 34', 34);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/i/microphone-co-day-saramonic-sr-mv2000.png', 'Ảnh sản phẩm 35', 35);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_208_1.png', 'Ảnh sản phẩm 36', 36);


INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/_/t_i_xu_ng_-_2023-01-02t221507...._2.png', 'Ảnh sản phẩm 37', 37);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/1/_/1.10.png', 'Ảnh sản phẩm 38', 38);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_314_8_.png', 'Ảnh sản phẩm 39', 39);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_251_1__1_2.png', 'Ảnh sản phẩm 40', 40);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/b/a/ban-phim-keychron-k8-1.png', 'Ảnh sản phẩm 41', 41);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/b/a/ban-phim-bluetooth-logitech-pe...12.png', 'Ảnh sản phẩm 42', 42);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/b/a/ban-phim-co-razer-blackwidow-v...ch.png', 'Ảnh sản phẩm 43', 43);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/f/r/frame_379_-_2025-05-16t111644.812.png', 'Ảnh sản phẩm 44', 44);
INSERT INTO product_images (url, alt, product_id) VALUES ('https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/b/a/ban-phim-co-khong-day-dareu-ek...-2.png', 'Ảnh sản phẩm 45', 45);
