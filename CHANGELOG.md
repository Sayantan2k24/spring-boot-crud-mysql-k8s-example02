# Changelog

## v1.1.0 - 2025-04-13

### Added:
- **Search by Keyword**: Implemented a new `/products/search` endpoint for searching products by name (case-insensitive) using a keyword.
- **Search by Category and Price**: Implemented a new `/products/searchByCategoryAndPrice` endpoint for searching products by category and filtering by a price range (min and max price).

### Changes:
- **ProductService**: Added methods `searchByName` and `searchByCategoryAndPrice` to support the new search functionalities.
- **ProductController**: Added endpoints to handle the new search functionality for both keyword and category-price range.
  
### Fixed:
- **Product Entity**: Ensured that the `category` field is present and correctly mapped to support searching by category.

### Notes:
- Database schema has been updated with the `category` field in the `PRODUCT_TBL` table to support filtering by category.
