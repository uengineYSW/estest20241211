<template>

    <v-data-table
        :headers="headers"
        :items="dispatchRequestDetails"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DispatchRequestDetailsView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "dispatchRequestId", value: "dispatchRequestId" },
                { text: "requester", value: "requester" },
                { text: "approvalInfo", value: "approvalInfo" },
                { text: "dispatchPurpose", value: "dispatchPurpose" },
                { text: "dispatchPeriod", value: "dispatchPeriod" },
                { text: "vehicleType", value: "vehicleType" },
                { text: "numberOfPassengers", value: "numberOfPassengers" },
                { text: "driverIncluded", value: "driverIncluded" },
                { text: "remarks", value: "remarks" },
                { text: "contactNumber", value: "contactNumber" },
                { text: "attachment", value: "attachment" },
                { text: "status", value: "status" },
            ],
            dispatchRequestDetails : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/dispatchRequestDetails'))

            temp.data._embedded.dispatchRequestDetails.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.dispatchRequestDetails = temp.data._embedded.dispatchRequestDetails;
        },
        methods: {
        }
    }
</script>

