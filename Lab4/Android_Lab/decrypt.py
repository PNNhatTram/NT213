import base64

# Chuỗi mã hóa base64
encrypted_password = b"RVZBQlN7bmV2M3Jfc3QwcmU=X3MzbnMhdGl2M19kYXRhXzFuXzdoM19zMHVyY2VjMGRl"

# Giải mã base64
decoded = base64.b64decode(encrypted_password)

# Chuyển đổi dữ liệu giải mã thành chuỗi (giả sử chuỗi là text)
decrypted = decoded.decode('utf-8')

# In kết quả
print(decoded)

