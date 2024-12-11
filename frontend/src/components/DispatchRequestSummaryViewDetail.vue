<template>

    <v-card outlined>
        <v-card-title>
            DispatchRequestSummary # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="DispatchRequestId" v-model="item.dispatchRequestId" :editMode="editMode" @change="change" />
            </div>
            <Requester offline label="Requester" v-model="item.requester" :editMode="false" :key="false" @change="change" />
            <DispatchPurpose offline label="DispatchPurpose" v-model="item.dispatchPurpose" :editMode="false" :key="false" @change="change" />
            <DispatchPeriod offline label="DispatchPeriod" v-model="item.dispatchPeriod" :editMode="false" :key="false" @change="change" />
            <VehicleType offline label="VehicleType" v-model="item.vehicleType" :editMode="false" :key="false" @change="change" />
            <DispatchStatus offline label="Status" v-model="item.status" :editMode="false" :key="false" @change="change" />
            <div>
                <Number label="NumberOfPassengers" v-model="item.numberOfPassengers" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="DriverIncluded" v-model="item.driverIncluded" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Remarks" v-model="item.remarks" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ContactNumber" v-model="item.contactNumber" :editMode="editMode" @change="change" />
            </div>
            <File offline label="Attachment" v-model="item.attachment" :editMode="false" :key="false" @change="change" />
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'DispatchRequestSummaryViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/dispatchRequestSummaries/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

