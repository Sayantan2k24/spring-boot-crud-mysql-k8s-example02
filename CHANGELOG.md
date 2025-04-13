# Changelog

## [v2.0.0] - 2025-04-13

### 🚀 Added
- New repository methods in `ProductRepository` for advanced product search:
  - `findByCategory(String category)`
  - `findByPriceBetween(double minPrice, double maxPrice)`
  - `findByCategoryAndPriceBetween(String category, double minPrice, double maxPrice)`

- Flexible search logic in `ProductService`:
  - Method `searchByCategoryAndPrice()` to handle combinations of category, minPrice, and maxPrice.

- Corresponding endpoint in `ProductController` to expose search functionality via REST API.

### 🔧 Changed
- Updated controller to include search endpoint for better client interaction.
- Minor refactoring for code clarity and consistency.

### 🧪 Tested
- Verified CRUD operations.
- Confirmed search functionality works for all parameter combinations.

### 📦 Versioning
- Tagged as `v2.0.0` to reflect new feature set beyond basic CRUD.

---

