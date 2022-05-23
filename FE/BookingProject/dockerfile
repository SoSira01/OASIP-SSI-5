FROM node:latest as build-stage
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY ./ .
RUN npm run build

FROM nginx as production-stage
RUN mkdir /app
COPY --from=build-stage /app/dist /app
COPY /nginx.conf /etc/nginx/nginx.conf

# version: '3'
# services:
#   database:
#     build: "./database"
#     restart: always
#     volumes:
#       - "./database/script:/docker-entrypoint-initdb.d/"
#     container_name: DB
#     image: db1
#     ports:
#       - "3306:3306"
#     environment:
#       MYSQL_ROOT_PASSWORD: "123456"
#       LANG: "C.UTF-8"
#       TZ: "Asia/Bangkok"
#       character-set-server: "utf8mb4"
#       collation-server: "utf8mb4_unicode_ci"
    
#   backend:
#     build: "./backend"
#     restart: always
#     ports:
#       - "8080:8080"
#     container_name: BE
#     image: beimg
#     depends_on:
#       - database

#   frontend:
#     build: ./frontend
#     restart: always
#     ports:
#       - '3000:80'
#     container_name: FE
#     image: feimg

#   reverseproxy:
#     image: nginx
#     restart: always
#     container_name: proxy
#     volumes:
#       - ./reverseproxy/nginx.conf:/etc/nginx/conf.d:/default.conf
#     depends_on:
#       - database
#       - backend
#       - frontend
#     ports:
#       - "80:80"

# networks:
#   default:
#     external:
#         name: project