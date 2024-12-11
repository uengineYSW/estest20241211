<template>

    <v-data-table
        :headers="headers"
        :items="dispatchStatusDetails"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DispatchStatusDetailsView',
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
            dispatchStatusDetails : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/dispatchStatusDetails'))

            temp.data._embedded.dispatchStatusDetails.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.dispatchStatusDetails = temp.data._embedded.dispatchStatusDetails;
        },
        methods: {
        }
    }
</script>

