FROM node:lts-alpine3.17

WORKDIR /app

COPY package* ./
RUN npm install

COPY ./start.sh ../
RUN ["chmod","+x","../start.sh"]

COPY . ./

EXPOSE 3000

CMD ["../start.sh"]