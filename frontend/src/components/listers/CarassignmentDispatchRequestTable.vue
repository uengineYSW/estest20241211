<template>
    <div>
        <v-data-table
                :headers="headers"
                :items="values"
                :items-per-page="5"
                class="elevation-1"
        ></v-data-table>

        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                        v-model="openDialog"
                        width="332.5"
                        fullscreen
                        hide-overlay
                        transition="dialog-bottom-transition"
                >
                    <template v-slot:activator="{ on, attrs }">
                        <v-fab-transition>
                            <v-btn
                                    color="primary"
                                    fab
                                    dark
                                    large
                                    style="position:absolute; bottom: 5%; right: 2%; z-index:99"
                                    @click="openDialog=true;"
                            >
                                <v-icon v-bind="attrs" v-on="on">mdi-plus</v-icon>
                            </v-btn>
                        </v-fab-transition>
                    </template>

                    <CarassignmentDispatchRequest :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
                
                    <v-btn
                            style="postition:absolute; top:2%; right:2%"
                            @click="closeDialog()"
                            depressed 
                            icon 
                            absolute
                    >
                        <v-icon>mdi-close</v-icon>
                    </v-btn>
                </v-dialog>
            </div>
        </v-col>
    </div>
</template>

<script>
    const axios = require('axios').default;
    import CarassignmentDispatchRequest from './../CarassignmentDispatchRequest.vue';

    export default {
        name: 'CarassignmentDispatchRequestManager',
        components: {
            CarassignmentDispatchRequest,
        },
        props: {
            offline: Boolean,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            values: [],
            headers: 
                [
                    { text: "dispatchRequestId", value: "dispatchRequestId" },
                    { text: "requester", value: "requester" },
                    { text: "approvalInfo", value: "approvalInfo" },
                    { text: "dispatchPeriod", value: "dispatchPeriod" },
                    { text: "dispatchPurpose", value: "dispatchPurpose" },
                    { text: "status", value: "status" },
                    { text: "vehicleType", value: "vehicleType" },
                    { text: "numberOfPassengers", value: "numberOfPassengers" },
                    { text: "driverIncluded", value: "driverIncluded" },
                    { text: "remarks", value: "remarks" },
                    { text: "contactNumber", value: "contactNumber" },
                    { text: "attachment", value: "attachment" },
                ],
            dispatchRequest : [],
            newValue: {},
            tick : true,
            openDialog : false,
        }),
        async created() {
            if(this.offline){
                if(!this.values) this.values = [];
                return;
            }

            var temp = await axios.get(axios.fixUrl('/dispatchrequests'))
            temp.data._embedded.dispatchrequests.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])
            this.values = temp.data._embedded.dispatchrequests;

            this.newValue = {
                'dispatchRequestId': 0,
                'requester': {},
                'approvalInfo': {},
                'dispatchPeriod': {},
                'dispatchPurpose': {},
                'status': '',
                'vehicleType': '',
                'numberOfPassengers': 0,
                'driverIncluded': false,
                'remarks': '',
                'contactNumber': '',
                'attachment': {},
            }
        },
        methods: {
            closeDialog(){
                this.openDialog = false
            },
            append(value){
                this.tick = false
                this.newValue = {}
                this.values.push(value)
                
                this.$emit('input', this.values);

                this.$nextTick(function(){
                    this.tick=true
                })
            },
        }
    }
</script>

