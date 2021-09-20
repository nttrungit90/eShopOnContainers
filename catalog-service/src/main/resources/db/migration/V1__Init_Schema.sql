DROP TABLE IF EXISTS CatalogBrand;
CREATE TABLE CatalogBrand (
    Id int,
    Brand nvarchar(100),
    PRIMARY KEY (Id)
);

DROP TABLE IF EXISTS CatalogType;
CREATE TABLE CatalogType (
    Id int,
    Type nvarchar(100),
    PRIMARY KEY (Id)
);

DROP TABLE IF EXISTS Catalog;
CREATE TABLE Catalog (
    Id int,
    CatalogBrandId int,
    CatalogTypeId int,
    Description nvarchar(MAX),
    Name nvarchar(50),
    PictureFileName nvarchar(MAX),
    Price decimal(18,2),
    AvailableStock int DEFAULT ((0)),
    MaxStockThreshold int DEFAULT ((0)),
    OnReorder bit DEFAULT (CONVERT(bit,(0))),
    RestockThreshold int DEFAULT ((0)),
    PRIMARY KEY (Id)
);

DROP TABLE IF EXISTS IntegrationEventLog;
CREATE TABLE IntegrationEventLog (
    EventId uniqueidentifier,
    Content nvarchar(MAX),
    CreationTime datetime2(7),
    EventTypeName nvarchar(MAX),
    State int,
    TimesSent int,
    TransactionId nvarchar(MAX),
    PRIMARY KEY (EventId)
);

