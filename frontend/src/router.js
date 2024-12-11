
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import CarassignmentDispatchRequestManager from "./components/listers/CarassignmentDispatchRequestCards"
import CarassignmentDispatchRequestDetail from "./components/listers/CarassignmentDispatchRequestDetail"
import CarassignmentDispatchStatusManager from "./components/listers/CarassignmentDispatchStatusCards"
import CarassignmentDispatchStatusDetail from "./components/listers/CarassignmentDispatchStatusDetail"

import DispatchRequestSummaryView from "./components/DispatchRequestSummaryView"
import DispatchRequestSummaryViewDetail from "./components/DispatchRequestSummaryViewDetail"
import DispatchRequestDetailsView from "./components/DispatchRequestDetailsView"
import DispatchRequestDetailsViewDetail from "./components/DispatchRequestDetailsViewDetail"
import DispatchStatusSummaryView from "./components/DispatchStatusSummaryView"
import DispatchStatusSummaryViewDetail from "./components/DispatchStatusSummaryViewDetail"
import DispatchStatusDetailsView from "./components/DispatchStatusDetailsView"
import DispatchStatusDetailsViewDetail from "./components/DispatchStatusDetailsViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/carassignments/dispatchRequests',
                name: 'CarassignmentDispatchRequestManager',
                component: CarassignmentDispatchRequestManager
            },
            {
                path: '/carassignments/dispatchRequests/:id',
                name: 'CarassignmentDispatchRequestDetail',
                component: CarassignmentDispatchRequestDetail
            },
            {
                path: '/carassignments/dispatchStatuses',
                name: 'CarassignmentDispatchStatusManager',
                component: CarassignmentDispatchStatusManager
            },
            {
                path: '/carassignments/dispatchStatuses/:id',
                name: 'CarassignmentDispatchStatusDetail',
                component: CarassignmentDispatchStatusDetail
            },

            {
                path: '/carassignments/dispatchRequestSummaries',
                name: 'DispatchRequestSummaryView',
                component: DispatchRequestSummaryView
            },
            {
                path: '/carassignments/dispatchRequestSummaries/:id',
                name: 'DispatchRequestSummaryViewDetail',
                component: DispatchRequestSummaryViewDetail
            },
            {
                path: '/carassignments/dispatchRequestDetails',
                name: 'DispatchRequestDetailsView',
                component: DispatchRequestDetailsView
            },
            {
                path: '/carassignments/dispatchRequestDetails/:id',
                name: 'DispatchRequestDetailsViewDetail',
                component: DispatchRequestDetailsViewDetail
            },
            {
                path: '/carassignments/dispatchStatusSummaries',
                name: 'DispatchStatusSummaryView',
                component: DispatchStatusSummaryView
            },
            {
                path: '/carassignments/dispatchStatusSummaries/:id',
                name: 'DispatchStatusSummaryViewDetail',
                component: DispatchStatusSummaryViewDetail
            },
            {
                path: '/carassignments/dispatchStatusDetails',
                name: 'DispatchStatusDetailsView',
                component: DispatchStatusDetailsView
            },
            {
                path: '/carassignments/dispatchStatusDetails/:id',
                name: 'DispatchStatusDetailsViewDetail',
                component: DispatchStatusDetailsViewDetail
            },


    ]
})
