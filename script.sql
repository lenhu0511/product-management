USE [master]
GO
/****** Object:  Database [ProductManager]    Script Date: 7/22/2021 10:20:20 AM ******/
CREATE DATABASE [ProductManager]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ProductManager', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\ProductManager.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ProductManager_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\ProductManager_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [ProductManager] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ProductManager].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ProductManager] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProductManager] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProductManager] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProductManager] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProductManager] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProductManager] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProductManager] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProductManager] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProductManager] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProductManager] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProductManager] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProductManager] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProductManager] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProductManager] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProductManager] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProductManager] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProductManager] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProductManager] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProductManager] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProductManager] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProductManager] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProductManager] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProductManager] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ProductManager] SET  MULTI_USER 
GO
ALTER DATABASE [ProductManager] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProductManager] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProductManager] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProductManager] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [ProductManager] SET DELAYED_DURABILITY = DISABLED 
GO
USE [ProductManager]
GO
/****** Object:  Table [dbo].[tblCategories]    Script Date: 7/22/2021 10:20:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblCategories](
	[categoryID] [varchar](10) NOT NULL,
	[categoryName] [nvarchar](50) NULL,
	[description] [nvarchar](200) NULL,
 CONSTRAINT [PK_tblCategories] PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblProducts]    Script Date: 7/22/2021 10:20:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblProducts](
	[productID] [varchar](10) NOT NULL,
	[productName] [nvarchar](50) NULL,
	[unit] [varchar](50) NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[categoryid] [varchar](10) NULL,
 CONSTRAINT [PK_tblProducts] PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblUsers]    Script Date: 7/22/2021 10:20:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblUsers](
	[userID] [varchar](10) NOT NULL,
	[fullName] [nvarchar](50) NULL,
	[password] [varchar](50) NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_tblUsers] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tblCategories] ([categoryID], [categoryName], [description]) VALUES (N'NV', N'Nova', N'TP HCM')
INSERT [dbo].[tblCategories] ([categoryID], [categoryName], [description]) VALUES (N'PV', N'Phong Vu ', N'TP HCM')
INSERT [dbo].[tblCategories] ([categoryID], [categoryName], [description]) VALUES (N'TT', N'Thien Tam', N'TP HCM')
INSERT [dbo].[tblProducts] ([productID], [productName], [unit], [price], [quantity], [categoryid]) VALUES (N'P001', N'Mouse ', N'block 10', 40, 10, N'PV')
INSERT [dbo].[tblProducts] ([productID], [productName], [unit], [price], [quantity], [categoryid]) VALUES (N'P002', N'Keyboard ', N'block 10', 60, 30, N'PV')
INSERT [dbo].[tblProducts] ([productID], [productName], [unit], [price], [quantity], [categoryid]) VALUES (N'P003', N'LCD', N'1-unit', 90, 40, N'PV')
INSERT [dbo].[tblProducts] ([productID], [productName], [unit], [price], [quantity], [categoryid]) VALUES (N'P004', N'Laptop Asus', N'1-unit', 520, 10, N'NV')
INSERT [dbo].[tblProducts] ([productID], [productName], [unit], [price], [quantity], [categoryid]) VALUES (N'P005', N'USB 2.0 Kingstion- 4GB', N'1-unit', 20, 50, N'NV')
INSERT [dbo].[tblProducts] ([productID], [productName], [unit], [price], [quantity], [categoryid]) VALUES (N'P006', N'Laptop Dell', N'1-unit', 480, 20, N'NV')
INSERT [dbo].[tblProducts] ([productID], [productName], [unit], [price], [quantity], [categoryid]) VALUES (N'P007', N'Blank DVD Giga', N'block 100', 30, 20, N'TT')
INSERT [dbo].[tblProducts] ([productID], [productName], [unit], [price], [quantity], [categoryid]) VALUES (N'P008', N'Blank CD', N'block 100', 20, 10, N'TT')
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [status]) VALUES (N'SE123456', N'LE NHU', N'123', 0)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [status]) VALUES (N'SE140801', N'LE THI CAM NHU', N'05112000', 1)
ALTER TABLE [dbo].[tblProducts]  WITH CHECK ADD  CONSTRAINT [FK_tblProducts_tblCategories] FOREIGN KEY([categoryid])
REFERENCES [dbo].[tblCategories] ([categoryID])
GO
ALTER TABLE [dbo].[tblProducts] CHECK CONSTRAINT [FK_tblProducts_tblCategories]
GO
USE [master]
GO
ALTER DATABASE [ProductManager] SET  READ_WRITE 
GO
