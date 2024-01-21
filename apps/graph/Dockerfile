FROM registry.access.redhat.com/ubi8/nodejs-18 AS builder

USER 1001

WORKDIR /usr/src/app

RUN npm install --global yarn -s &>/dev/null

COPY --chown=1001:1001 package*.json ./

RUN yarn install --frozen-lockfile

COPY --chown=1001:1001 tsconfig*.json ./

COPY --chown=1001:1001 src src
COPY --chown=1001:1001 schema.gen.graphql ./
COPY --chown=1001:1001 prisma prisma

RUN yarn run build

FROM registry.access.redhat.com/ubi8/nodejs-18-minimal

USER 1001

WORKDIR /usr/src/app

RUN npm install --global yarn -s &>/dev/null

COPY --chown=1001:1001 --from=builder /usr/src/app/package*.json/ .
RUN yarn install --frozen-lockfile --production 
COPY --chown=1001:1001 --from=builder /usr/src/app/dist/ dist/

ENV NODE_ENV=production

EXPOSE 4000

CMD [ "node", "dist/index.js" ]