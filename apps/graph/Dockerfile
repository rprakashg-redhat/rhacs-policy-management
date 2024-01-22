FROM registry.access.redhat.com/ubi8/nodejs-18-minimal

RUN npm install --global yarn -s &>/dev/null

COPY  ./package*.json .
RUN yarn install --frozen-lockfile --production 
COPY dist  .
COPY prisma ./prisma/
RUN ls 
ENV NODE_ENV=production

EXPOSE 4000

CMD [ "node", "index.js" ]