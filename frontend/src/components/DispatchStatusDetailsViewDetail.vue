<template>

    <v-card outlined>
        <v-card-title>
            DispatchStatusDetails # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="DispatchStatusId" v-model="item.dispatchStatusId" :editMode="editMode" @change="change" />
            </div>
            <DispatchRequestReference offline label="DispatchRequestReference" v-model="item.dispatchRequestReference" :editMode="false" :key="false" @change="change" />
            <div>
                <Date label="ApprovalDate" v-model="item.approvalDate" :editMode="editMode" @change="change" />
            </div>
            <ProgressStage offline label="ProgressStage" v-model="item.progressStage" :editMode="false" :key="false" @change="change" />
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'DispatchStatusDetailsViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/dispatchStatusDetails/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

