<template>

    <v-data-table
        :headers="headers"
        :items="dispatchStatusSummary"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DispatchStatusSummaryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "dispatchStatusId", value: "dispatchStatusId" },
                { text: "dispatchRequestReference", value: "dispatchRequestReference" },
                { text: "approvalDate", value: "approvalDate" },
                { text: "progressStage", value: "progressStage" },
            ],
            dispatchStatusSummary : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/dispatchStatusSummaries'))

            temp.data._embedded.dispatchStatusSummaries.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.dispatchStatusSummary = temp.data._embedded.dispatchStatusSummaries;
        },
        methods: {
        }
    }
</script>

