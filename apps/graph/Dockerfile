FROM registry.access.redhat.com/ubi8/nodejs-18-minimal

USER 1001

WORKDIR /usr/src/app

RUN npm install --global yarn -s &>/dev/null

COPY --chown=1001:1001 --from=builder /usr/src/app/package*.json/ .
RUN yarn install --frozen-lockfile --production 
COPY --chown=1001:1001 dist  ./dist

ENV NODE_ENV=production

EXPOSE 4000

CMD [ "node", "dist/index.js" ]