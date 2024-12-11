<template>

    <v-data-table
        :headers="headers"
        :items="dispatchRequestSummary"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DispatchRequestSummaryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "dispatchRequestId", value: "dispatchRequestId" },
                { text: "requester", value: "requester" },
                { text: "dispatchPurpose", value: "dispatchPurpose" },
                { text: "dispatchPeriod", value: "dispatchPeriod" },
                { text: "vehicleType", value: "vehicleType" },
                { text: "status", value: "status" },
                { text: "numberOfPassengers", value: "numberOfPassengers" },
                { text: "driverIncluded", value: "driverIncluded" },
                { text: "remarks", value: "remarks" },
                { text: "contactNumber", value: "contactNumber" },
                { text: "attachment", value: "attachment" },
            ],
            dispatchRequestSummary : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/dispatchRequestSummaries'))

            temp.data._embedded.dispatchRequestSummaries.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.dispatchRequestSummary = temp.data._embedded.dispatchRequestSummaries;
        },
        methods: {
        }
    }
</script>

