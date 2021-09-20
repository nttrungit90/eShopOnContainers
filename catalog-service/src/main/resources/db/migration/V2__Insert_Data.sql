INSERT INTO CatalogType (Id, Type) VALUES
('1', N'Mug'),
('2', N'T-Shirt'),
('3', N'Pin');

INSERT INTO CatalogBrand (Id, Brand) VALUES
('1', N'.NET'),
('2', N'Other');

INSERT INTO Catalog (Id, CatalogBrandId, CatalogTypeId, Description, Name, PictureFileName, Price, AvailableStock, MaxStockThreshold, OnReorder, RestockThreshold) VALUES
('1', '1', '2', N'.NET Bot Black Hoodie, and more', N'.NET Bot Black Hoodie', N'1.png', '19.50', '100', '0', '0', '0'),
('2', '1', '1', N'.NET Black & White Mug', N'.NET Black & White Mug', N'2.png', '8.50', '89', '0', '1', '0'),
('3', '2', '2', N'Prism White T-Shirt', N'Prism White T-Shirt', N'3.png', '12.00', '56', '0', '0', '0'),
('4', '1', '2', N'.NET Foundation T-shirt', N'.NET Foundation T-shirt', N'4.png', '12.00', '120', '0', '0', '0'),
('5', '2', '3', N'Roslyn Red Pin', N'Roslyn Red Pin', N'5.png', '8.50', '55', '0', '0', '0'),
('6', '1', '2', N'.NET Blue Hoodie', N'.NET Blue Hoodie', N'6.png', '12.00', '17', '0', '0', '0'),
('7', '2', '2', N'Roslyn Red T-Shirt', N'Roslyn Red T-Shirt', N'7.png', '12.00', '8', '0', '0', '0'),
('8', '2', '2', N'Kudu Purple Hoodie', N'Kudu Purple Hoodie', N'8.png', '8.50', '34', '0', '0', '0'),
('9', '2', '1', N'Cup<T> White Mug', N'Cup<T> White Mug', N'9.png', '12.00', '76', '0', '0', '0'),
('10', '1', '3', N'.NET Foundation Pin', N'.NET Foundation Pin', N'10.png', '12.00', '11', '0', '0', '0'),
('11', '1', '3', N'Cup<T> Pin', N'Cup<T> Pin', N'11.png', '8.50', '3', '0', '0', '0'),
('12', '2', '2', N'Prism White TShirt', N'Prism White TShirt', N'12.png', '12.00', '0', '0', '0', '0'),
('13', '1', '1', N'Modern .NET Black & White Mug', N'Modern .NET Black & White Mug', N'13.png', '8.50', '89', '0', '1', '0'),
('14', '2', '1', N'Modern Cup<T> White Mug', N'Modern Cup<T> White Mug', N'14.png', '12.00', '76', '0', '0', '0');