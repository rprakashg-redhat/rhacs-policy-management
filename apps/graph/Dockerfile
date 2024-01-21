FROM registry.access.redhat.com/ubi8/nodejs-18-minimal

USER 1001

RUN mkdir -p /home/app/node_modules && chown -R 1001:1001 /home/app

WORKDIR /home/app

RUN npm install --global yarn -s &>/dev/null

COPY  ./package*.json .
RUN yarn install --frozen-lockfile --production 
COPY dist  .

ENV NODE_ENV=production

EXPOSE 4000

CMD [ "node", "index.js" ]