<template>
    <v-card outlined>
        <v-card-title>
            DispatchRequest # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="DispatchRequestId" v-model="item.dispatchRequestId" :editMode="editMode" @change="change" />
            </div>
            <Requester offline label="Requester" v-model="item.requester" :editMode="false" :key="false" @change="change" />
            <ApprovalInfo offline label="ApprovalInfo" v-model="item.approvalInfo" :editMode="false" :key="false" @change="change" />
            <DispatchPeriod offline label="DispatchPeriod" v-model="item.dispatchPeriod" :editMode="false" :key="false" @change="change" />
            <DispatchPurpose offline label="DispatchPurpose" v-model="item.dispatchPurpose" :editMode="false" :key="false" @change="change" />
            <DispatchStatus offline label="Status" v-model="item.status" :editMode="false" :key="false" @change="change" />
            <VehicleType offline label="VehicleType" v-model="item.vehicleType" :editMode="false" :key="false" @change="change" />
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

        <v-card-actions>
            <v-btn text color="deep-purple lighten-2" large @click="goList">List</v-btn>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="edit"
                    v-if="!editMode"
            >
                Edit
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="save"
                    v-else
            >
                Save
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="remove"
                    v-if="!editMode"
            >
                Delete
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="editMode = false"
                    v-if="editMode"
            >
                Cancel
            </v-btn>
        </v-card-actions>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'CarassignmentDispatchRequestDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
            editMode: false,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/dispatchRequests/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
            goList() {
                var path = window.location.href.slice(window.location.href.indexOf("/#/"), window.location.href.lastIndexOf("/#"));
                path = path.replace("/#/", "/");
                this.$router.push(path);
            },
            edit() {
                this.editMode = true;
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.item._links.self.href))
                    }

                    this.editMode = false;

                    this.$emit('input', this.item);
                    this.$emit('delete', this.item);

                } catch(e) {
                    console.log(e)
                }
            },
        },
    };
</script>
