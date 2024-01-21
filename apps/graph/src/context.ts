import SchedulerAPI from "./datasources/scheduler-api"
import { Request } from "express";
import { ReviewsDB } from "./datasources/reviews-db";

export interface Context {
    api: SchedulerAPI
    db: ReviewsDB
}
const serviceName = process.env.SCHEDULER_SERVICE;
const api = new SchedulerAPI("http://" + serviceName)
const db = new ReviewsDB();

export const context = ({ req }: { req: Request }): Context => {
    return {
        api,
        db
    }
}
