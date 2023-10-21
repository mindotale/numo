FROM node

ENV APP_HOME=/usr/app
WORKDIR $APP_HOME

COPY .. .
RUN npm install -g live-server

ENTRYPOINT ["npx", "live-server"]
