import socket
import csv

# Đọc danh sách subdomain từ file
with open('BaiTap1.csv', 'r') as file:
    subdomains = [line.strip() for line in file.readlines()]

# Mở file CSV để ghi kết quả
with open('IP.csv', 'w', newline='') as csvfile:
    fieldnames = ['IP Address']
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)

    # Ghi tiêu đề cột
    writer.writeheader()

    # Lấy IP của từng subdomain
    for subdomain in subdomains:
        try:
            # Sử dụng socket để lấy IP từ domain
            ip_address = socket.gethostbyname(subdomain)
            # Ghi vào file CSV
            writer.writerow({'IP Address': ip_address})
        except socket.gaierror:
            # Xử lý nếu không tìm thấy IP
            continue

print("Hoàn tất!")
