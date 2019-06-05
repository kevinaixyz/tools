DROP stock;
CREATE TABLE stock(ticker varchar(20) primary key, stock_code varchar(20), exp_price double, sd double, start_price double);
insert into stock(ticker, stock_code, exp_price, sd, start_price) values ('1.HK','0001', 88.00, 0.2, 80.2);
insert into stock(ticker, stock_code, exp_price, sd, start_price) values ('2.HK','0002', 95.00, 0.5, 91.550);
insert into stock(ticker, stock_code, exp_price, sd, start_price) values ('3.HK','0003', 20.00, 0.6, 18.280);

DROP stock_option;
CREATE TABLE stock_option(isin varchar(20) primary key, stock_ticker varchar(20), long_short varchar(5), strk_price double, maturity_yr double);
insert into stock_option(isin, stock_ticker, long_short, strk_price, maturity_yr) values ('hk1000001','1.HK','Long', 100.00, 0.5, 1.5);
insert into stock_option(isin, stock_ticker, long_short, strk_price, maturity_yr) values ('hk1000002','2.HK','Short', 100.00, 0.5, 0.5);
insert into stock_option(isin, stock_ticker, long_short, strk_price, maturity_yr) values ('hk1000003','3.HK','Long', 100.00, 0.5, 1);