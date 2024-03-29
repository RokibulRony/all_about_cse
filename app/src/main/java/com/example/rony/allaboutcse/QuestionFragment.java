package com.example.rony.allaboutcse;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuestionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuestionFragment} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    // TODO: Rename and change types of parameters

    private QuestionFragment.OnFragmentInteractionListener mListener;

    public QuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment SyllabusFragment.
     */
    // TODO: Rename and change types and number of parameters

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_question, container, false);
        getActivity().setTitle("Board Questions");
        expListView = (ExpandableListView)rootView.findViewById(R.id.lvExp);
        prepareListData();
        listAdapter = new ExpandableListAdapter(getActivity().getApplicationContext(), listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return false;
            }
        });


        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub


                switch(groupPosition){

                    case 0:
                        switch(childPosition) {


                            case 0: {

                                Intent i= new Intent(getActivity(),FirstQuestionActivity.class);
                                getActivity().startActivity(i);
                                break;
                            }

                            case 1:{

                                Intent i= new Intent(getActivity(),SecondQuestionActivity.class);
                                getActivity().startActivity(i);
                                break;
                            }
                        }
                        break;
                    case 1:

                        switch(childPosition) {


                            case 0:

                            {

                                Intent i= new Intent(getActivity(),ThirdQuestionActivity.class);
                                getActivity().startActivity(i);
                                break;
                            }
                            case 1:

                            {

                                Intent i= new Intent(getActivity(),FourthQuestionActivity.class);
                                getActivity().startActivity(i);
                                break;
                            }
                        }
                        break;
                    case 2:
                        switch(childPosition) {

                            case 0:

                            {

                                Intent i= new Intent(getActivity(),FifthQuestionActivity.class);
                                getActivity().startActivity(i);
                                break;
                            }
                            case 1:

                            {

                                Intent i= new Intent(getActivity(),SixthQuestionActivity.class);
                                getActivity().startActivity(i);
                                break;
                            }
                        }
                        break;

                    case 3:
                        switch(childPosition) {

                            case 0:

                            {

                                Intent i= new Intent(getActivity(),SeventhQuestionActivity.class);
                                getActivity().startActivity(i);
                                break;
                            }
                            case 1:
                            {

                                Intent i= new Intent(getActivity(),EightQuestionActivity.class);
                                getActivity().startActivity(i);
                                break;
                            }

                        }
                        break;

                    default:
                        break;

                }
                return false;
            }

        });


        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("First Year");
        listDataHeader.add("Second Year");
        listDataHeader.add("Third year");
        listDataHeader.add("Fourth year");

        // Adding child data
        List<String> fst = new ArrayList<String>();
        fst.add("First Semester");
        fst.add("Second Semester");


        List<String> snd = new ArrayList<String>();
        snd.add("Third Semester");
        snd.add("Fourth Semester");

        List<String> trd = new ArrayList<String>();
        trd.add("Fifth Semester");
        trd.add("Sixth Semester");

        List<String> frt = new ArrayList<String>();
        frt.add("Seventh Semester");
        frt.add("Eight Semester");

        listDataChild.put(listDataHeader.get(0), fst); // Header, Child data
        listDataChild.put(listDataHeader.get(1), snd);
        listDataChild.put(listDataHeader.get(2), trd);
        listDataChild.put(listDataHeader.get(3), frt);
    }



    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() == 1) {
            moveTaskToBack(false);
        }
        else {
            super.onDestroy();
        }
    }


    private void moveTaskToBack(boolean b) {
        // TODO Auto-generated method stub

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
