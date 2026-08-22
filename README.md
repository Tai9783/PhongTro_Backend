# PhongTro Backend

Backend API cho ứng dụng tìm phòng trọ (Android), xây dựng bằng Spring Boot.

## Công nghệ sử dụng

- **Java 21**
- **Spring Boot 4.0.0** — `spring-boot-starter-web`, `spring-boot-starter-data-jpa`
- **MySQL** (`mysql-connector-java`) — cơ sở dữ liệu
- **Spring Security Crypto** — mã hóa password bằng BCrypt
- **Cloudinary** — lưu trữ và upload ảnh phòng trọ
- **Gradle** (kèm Gradle Wrapper) — build tool

## Yêu cầu môi trường

- JDK 21
- MySQL Server đang chạy, đã tạo sẵn database (mặc định `phongtro_db`)
- Tài khoản Cloudinary (nếu cần dùng chức năng upload ảnh)

## Cấu hình

Chỉnh sửa `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/phongtro_db?...
spring.datasource.username=root
spring.datasource.password=<mật khẩu MySQL của bạn>

cloudinary.cloud_name=<cloud name>
cloudinary.api_key=<api key>
cloudinary.api_secret=<api secret>
```

## Chạy dự án

```bash
./gradlew.bat bootRun
```

App mặc định chạy ở `http://localhost:8080`. Android Emulator gọi qua alias `http://10.0.2.2:8080/`.

Dừng bằng `Ctrl + C` trong terminal đang chạy.

## Cấu trúc project

Kiến trúc phân lớp (layered): `Controller → Service → Repository → Model`.

```
src/main/java/com/phongtroapp/phongtro_backend/
├── config/          # Bean cấu hình (Cloudinary, PasswordEncoder)
├── controller/      # REST controller, expose API
├── dto/             # Request/Response DTO
│   └── projection/  # Spring Data JPA projection interface (dùng nội bộ cho native query)
├── model/           # JPA Entity
├── repository/       # Interface Spring Data JPA
│   └── impl/        # Implementation tùy chỉnh (Criteria API...)
├── service/         # Interface nghiệp vụ
│   └── impl/        # Implementation nghiệp vụ
└── utils/           # Tiện ích dùng chung (converter...)
```

## API chính

### Phòng trọ (`/api/rooms`)

| Method | Endpoint | Mô tả |
|---|---|---|
| GET | `/api/rooms/featured` | Danh sách phòng nổi bật |
| GET | `/api/rooms/roomByPriceAndCity` | Lọc phòng theo giá và thành phố |
| GET | `/api/rooms/listCity` | Danh sách thành phố kèm số lượng phòng |
| GET | `/api/rooms/listWard` | Danh sách phường/xã theo thành phố |
| POST | `/api/rooms/filterRoom` | Lọc phòng nâng cao (giá, khu vực, tiện ích) |
| POST | `/api/rooms/createRentalRoom` | Tạo tin đăng phòng trọ mới |

### Bài đăng (`/api/roompost`, `/api/mypost`)

| Method | Endpoint | Mô tả |
|---|---|---|
| POST | `/api/roompost/saveroompost` | Tạo bài đăng quảng cáo cho 1 phòng |
| GET | `/api/mypost/getListPost?landlordId=` | Danh sách bài đăng của 1 chủ trọ |

### Người dùng (`/api/user`)

| Method | Endpoint | Mô tả |
|---|---|---|
| GET | `/api/user/getuser?taikhoan=&pass=` | Đăng nhập (email/sđt + password) |
| GET | `/api/user/getuserbyid?userId=` | Lấy thông tin user theo id |

Password được lưu dạng hash BCrypt, không bao giờ trả về trong response.

### Cloudinary (`/api/cloudinary`)

| Method | Endpoint | Mô tả |
|---|---|---|
| GET | `/api/cloudinary/signature` | Lấy chữ ký để upload ảnh trực tiếp lên Cloudinary từ client |
